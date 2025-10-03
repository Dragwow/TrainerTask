package com.yumimi.facade.impl;

import com.yumimi.client.CompanyClient;
import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.CompanyResponse;
import com.yumimi.db.response.UserResponse;
import com.yumimi.entity.Users;
import com.yumimi.facade.UserFacade;
import com.yumimi.service.UserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final CompanyClient companyClient;


    @Override
    public void create(UserRequest request) {
        Users user = new Users();
        setters(user, request);
        userService.create(user);

        if (user.getCompanyId() != null){
            companyClient.addUserToCompany(user.getCompanyId(), user.getId());
        }
    }

    @Override
    public void update(Long id, UserRequest request) {
        Users user = userService.findById(id);
        setters(user, request);
        userService.update(user);
    }

    @Override
    public void delete(Long id) {
        Users user = userService.findById(id);
        userService.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse getById(Long id) {
        Users user = userService.findById(id);

        CompanyResponse companyResponse = null;
        if (user.getCompanyId() != null) {
            companyResponse = companyClient.getById(user.getCompanyId());
        }

        return new UserResponse(user, companyResponse);
    }

    @Override
    public List<UserResponse> getAll() {
        List<Users> users = userService.findAll();

        return users.stream()
            .map(u -> {
                CompanyResponse companyResponse = null;
                if (u.getCompanyId() != null) {
                    companyResponse = companyClient.getById(u.getCompanyId());
                }
                return new UserResponse(u, companyResponse);
            })
            .toList();
    }

    @Override
    public List<UserResponse> getByCompanyId(Long companyId) {
        List<Users> users = userService.listByCompanyId(companyId);
        return users.stream()
            .map(u -> new UserResponse(u, null))
            .toList();

    }

    @Override
    public void assignToCompany(Long id, Long companyId) {
        Users user = userService.findById(id);
        user.setCompanyId(companyId);
        userService.update(user);
    }

    private void setters(Users user, UserRequest request) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setCompanyId(request.getCompanyId());
    }
}

