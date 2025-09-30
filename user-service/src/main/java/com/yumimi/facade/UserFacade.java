package com.yumimi.facade;

import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.UserResponse;

import java.util.List;

public interface UserFacade {

    UserResponse createUser(UserRequest request);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);

}
