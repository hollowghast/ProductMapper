package com.productmapper.controller;

import com.productmapper.entities.Company;
import com.productmapper.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @GetMapping("/all")
    public List<Company> getCompanies() {
        return service.getAll();
    }
}
