package com.yumimi.controller;

import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;
import com.yumimi.facade.CompanyFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyFacade companyFacade;

    @PostMapping
    public void create(
        @RequestBody
        CompanyRequest request) {
        companyFacade.create(request);
    }

    @PutMapping("/{id}")
    public void update(
        @PathVariable("id")
        Long id,
        @RequestBody
        CompanyRequest request) {
        companyFacade.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable("id")
        Long id) {
        companyFacade.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getById(
        @PathVariable("id")
        Long id) {
        return ResponseEntity
            .ok(companyFacade.getById(id));
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyFacade.getAll();
    }

    @PostMapping("/{companyId}/add-user/{userId}")
    public void addUserToCompany(
        @PathVariable("companyId") Long companyId,
        @PathVariable("userId") Long userId){
        companyFacade.addUserToCompany(companyId, userId);
    }
}
