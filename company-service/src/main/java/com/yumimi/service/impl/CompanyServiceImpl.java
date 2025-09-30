package com.yumimi.service.impl;

import com.yumimi.entity.Company;
import com.yumimi.exception.CompanyNotFoundException;
import com.yumimi.repository.CompanyRepository;
import com.yumimi.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public void create(Company entity) {
        repository.save(entity);
    }

    @Override
    public void update(Company entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Company entity) {
        repository.delete(entity);
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new CompanyNotFoundException("Company not founded"));
    }
}
