package com.productmapper.services;

import com.productmapper.entities.Brand;
import com.productmapper.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repo;

    public List<Brand> getAll() {
        return repo.findAll();
    }
}
