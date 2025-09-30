package com.yumimi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Company extends BaseEntity{

    private String name;
    private Integer budget;
    @ElementCollection
    @Column(name = "users_id")
    private List<Long> usersId = new ArrayList<>();

}
