package com.yumimi.facade.impl;

import com.yumimi.client.UsersClient;
import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;
import com.yumimi.entity.Company;
import com.yumimi.facade.CompanyFacade;
import com.yumimi.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {

    private final CompanyService companyService;
    private final UsersClient usersClient;

    @Override
    public CompanyResponse createCompany(CompanyRequest request) {
        Company company = new Company();

        company.setName(request.getName());
        company.setBudget(request.getBudget());

        companyService.create(company);

        return companyResponse(company);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest request) {
        Company company = companyService.findById(id);

        if (request.getName() != null) company.setName(request.getName());
        if (request.getBudget() != null) company.setBudget(request.getBudget());

        companyService.update(company);

        return companyResponse(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyService.findById(id);
        companyService.delete(company);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyService.findAll()
            .stream()
            .map(this::companyResponse)
            .toList();
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = companyService.findById(id);
        return companyResponse(company);
    }

    private CompanyResponse companyResponse(Company company) {
        CompanyResponse response = new CompanyResponse(company);

        if (company.getUsersId() != null && !company.getUsersId().isEmpty()) {
            try {
                response.setUsers(usersClient.getAllUsersById(company.getUsersId()));
            } catch (Exception e) {
                response.setUsers(List.of());
            }
        } else {
            response.setUsers(List.of());
        }

        return response;
    }
}
