package com.yumimi.facade.impl;

import com.yumimi.client.UsersClient;
import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;
import com.yumimi.db.response.UserResponse;
import com.yumimi.entity.Company;
import com.yumimi.facade.CompanyFacade;
import com.yumimi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {

    private final CompanyService companyService;
    private final UsersClient usersClient;


    @Override
    public void create(CompanyRequest request) {
        Company company = new Company();
        company.setName(request.getName());
        company.setBudget(request.getBudget());
        companyService.create(company);
    }

    @Override
    public void update(Long id, CompanyRequest request) {
        Company company = companyService.findById(id);
        company.setName(request.getName());
        company.setBudget(request.getBudget());
        companyService.update(company);
    }

    @Override
    public void delete(Long id) {
        Company company = companyService.findById(id);
        companyService.delete(company);
    }

    @Transactional(readOnly = true)
    @Override
    public CompanyResponse getById(Long id) {
        Company company = companyService.findById(id);
        List<UserResponse> users = getFullUsers(company);
        return new CompanyResponse(company, users);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CompanyResponse> getAll() {
        List<Company> companies = companyService.findAll();
        List<CompanyResponse> listCompanies = new ArrayList<>();
        for (Company c : companies) {
            listCompanies.add(new CompanyResponse(c, getFullUsers(c)));
        }
        return listCompanies;
    }

    @Override
    public void addUserToCompany(Long id, Long userId) {
        Company company = companyService.findById(id);
        usersClient.assignCompany(userId, id);
        companyService.update(company);
    }

    private List<UserResponse> getFullUsers(Company company) {
        return usersClient.getAllByCompanyId(company.getId());
    }
}
