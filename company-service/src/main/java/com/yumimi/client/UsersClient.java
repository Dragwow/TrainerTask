package com.yumimi.client;

import com.yumimi.db.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UsersClient {

    @GetMapping("/api/users/companies/{companyId}")
    List<UserResponse> getAllByCompanyId(
        @PathVariable("companyId") Long companyId);

    @PostMapping("/api/users/{userId}/assign-company/{companyId}")
    void assignCompany(
        @PathVariable("userId") Long userId,
        @PathVariable("companyId") Long companyId);
}
