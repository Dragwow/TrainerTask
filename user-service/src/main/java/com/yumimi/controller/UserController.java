package com.yumimi.controller;

import com.yumimi.db.request.UserRequest;
import com.yumimi.db.response.UserResponse;
import com.yumimi.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public void create(
        @RequestBody
        UserRequest request) {
        userFacade.create(request);
    }

    @PutMapping("/{id}")
    public void update(
        @PathVariable("id")
        Long id,
        @RequestBody
        UserRequest request) {
        userFacade.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable("id")
        Long id) {
        userFacade.delete(id);
    }

    @GetMapping("/{id}")
    public UserResponse getById(
        @PathVariable("id")
        Long id) {
        return userFacade.getById(id);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userFacade.getAll();
    }

    @GetMapping("/companies/{companyId}")
    public List<UserResponse> getAllByCompanyId(
        @PathVariable("companyId") Long companyId){
        return userFacade.getByCompanyId(companyId);
    }

    @PostMapping("/{userId}/assign-company/{companyId}")
    public void assignCompany(
        @PathVariable("userId") Long userId,
        @PathVariable("companyId") Long companyId){
        userFacade.assignToCompany(userId, companyId);
    }
}
