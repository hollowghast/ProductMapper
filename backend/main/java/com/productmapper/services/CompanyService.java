package com.productmapper.services;

import com.productmapper.entities.Company;
import com.productmapper.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repo;

    public List<Company> getAll(){
        return repo.findAll();
    }
}
