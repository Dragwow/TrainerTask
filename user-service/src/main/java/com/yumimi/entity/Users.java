package com.yumimi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Users extends BaseEntity{

    private String firstName;
    private String lastName;
    private String phone;
    private Long companyId;

}
