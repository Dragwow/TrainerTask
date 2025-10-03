package com.yumimi.entity;

import com.yumimi.db.response.UserResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Company extends BaseEntity{

    private String name;
    private Integer budget;

    @Transient
    private List<UserResponse> users;
}
