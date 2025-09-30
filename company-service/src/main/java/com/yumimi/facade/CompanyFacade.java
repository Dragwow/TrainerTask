package com.yumimi.facade;

import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;

import java.util.List;

public interface CompanyFacade {

    CompanyResponse createCompany(CompanyRequest request);
    CompanyResponse updateCompany(Long id, CompanyRequest request);
    void deleteCompany(Long id);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse getCompanyById(Long id);
}
