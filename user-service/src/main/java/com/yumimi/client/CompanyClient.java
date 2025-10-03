package com.yumimi.client;

import com.yumimi.db.response.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "company-service")
public interface CompanyClient {

    @GetMapping("/api/companies/{id}")
    CompanyResponse getById(@PathVariable("id") Long id);

    @PostMapping("api/companies/{id}/add-user/{userId}")
    void addUserToCompany(
        @PathVariable("id") Long companyId,
        @PathVariable("userId") Long id);
}
