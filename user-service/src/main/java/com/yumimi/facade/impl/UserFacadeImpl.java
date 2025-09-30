package com.yumimi.facade.impl;

import com.yumimi.client.CompanyClient;
import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.UserResponse;
import com.yumimi.entity.User;
import com.yumimi.facade.UserFacade;
import com.yumimi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final CompanyClient companyClient;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());

        userService.create(user);

        return userResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userService.findById(id);

        if (request.getFirstName() != null) user.setFirstName(request.getFirstName());
        if (request.getLastName() != null) user.setLastName(request.getLastName());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getCompanyId() != null) user.setCompanyId(request.getCompanyId());

        userService.update(user);

        return userResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userService.findById(id);
        userService.delete(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userService.findAll()
            .stream()
            .map(this::userResponse)
            .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userService.findById(id);
        return userResponse(user);
    }

    private UserResponse userResponse(User user) {
        UserResponse response = new UserResponse(user);

        if (user.getCompanyId() != null) {
            try {
                response.setCompany(companyClient.getCompanyById(user.getCompanyId()));
            } catch (Exception e) {
                response.setCompany(null);
            }
        }
        return response;
    }
}
