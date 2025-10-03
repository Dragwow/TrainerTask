package com.yumimi.facade;

import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;

import java.util.List;

public interface CompanyFacade {

    void create(CompanyRequest request);
    void update(Long id, CompanyRequest request);
    void delete(Long id);
    CompanyResponse getById(Long id);
    List<CompanyResponse> getAll();
    void addUserToCompany(Long id, Long userId);
}
