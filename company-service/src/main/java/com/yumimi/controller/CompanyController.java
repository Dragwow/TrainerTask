package com.yumimi.controller;

import com.yumimi.db.request.CompanyRequest;
import com.yumimi.db.response.CompanyResponse;
import com.yumimi.db.response.ResponseContainer;
import com.yumimi.facade.CompanyFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyFacade companyFacade;

    @PostMapping
    public ResponseEntity<ResponseContainer<CompanyResponse>> create(
        @RequestBody
        CompanyRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseContainer<>(companyFacade.createCompany(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<CompanyResponse>> update(
        @PathVariable
        Long id,
        @RequestBody
        CompanyRequest request) {
        return ResponseEntity
            .ok(new ResponseContainer<>(companyFacade.updateCompany(id, request)));
    }

    @DeleteMapping("/{id}")
    public void delete(
        @PathVariable
        Long id) {
        companyFacade.deleteCompany(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<CompanyResponse>> getById(
        @PathVariable
        Long id) {
        return ResponseEntity
            .ok(new ResponseContainer<>(companyFacade.getCompanyById(id)));
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyFacade.getAllCompanies();
    }

}
