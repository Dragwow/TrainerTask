package com.yumimi.client;

import com.yumimi.db.response.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "company-service")
public interface CompanyClient {

    @GetMapping("api/companies/{id}")
    CompanyResponse getCompanyById(@PathVariable("id") Long id);
}
