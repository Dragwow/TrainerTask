package com.yumimi.facade;

import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.UserResponse;

import java.util.List;

public interface UserFacade {

    void create(UserRequest request);
    void update(Long id, UserRequest request);
    void delete(Long id);
    UserResponse getById(Long id);
    List<UserResponse> getAll();
    List<UserResponse> getByCompanyId(Long companyId);
    void assignToCompany(Long id, Long companyId);
}
