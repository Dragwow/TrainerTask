package com.yumimi.db.response;

import com.yumimi.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyResponse {

    private Long id;
    private String name;
    private Integer budget;
    private List<UserResponse> users;

    public CompanyResponse(Company company, List<UserResponse> users){
        this.id = company.getId();
        this.name = company.getName();
        this.budget = company.getBudget();
        this.users = users;
    }
}
