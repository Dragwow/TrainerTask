package com.yumimi.service;

import com.yumimi.entity.BaseEntity;

import java.util.List;

public interface CrudService <E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(E entity);
    List<E> findAll();
    E findById(Long id);
}
