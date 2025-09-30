package com.yumimi.db.response;

import com.yumimi.entity.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {

    private Long id;
    private String name;
    private Integer budget;
    private List<UsersResponse> users;

    public CompanyResponse(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.budget = company.getBudget();
    }

    public void setUsers(List<UsersResponse> users){
        this.users = users;
    }
}
