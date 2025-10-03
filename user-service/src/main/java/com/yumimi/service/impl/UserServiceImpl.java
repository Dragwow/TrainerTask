package com.yumimi.service.impl;

import com.yumimi.entity.Users;
import com.yumimi.exception.UserNotFoundException;
import com.yumimi.repository.UserRepository;
import com.yumimi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void create(Users user) {
        repository.save(user);
    }

    @Override
    public void update(Users user) {
        repository.save(user);
    }

    @Override
    public void delete(Users user) {
        repository.delete(user);
    }

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not founded"));
    }


    @Override
    public List<Users> listByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }
}
