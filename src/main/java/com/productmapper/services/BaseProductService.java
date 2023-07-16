package com.productmapper.services;

import com.productmapper.entities.BaseProduct;
import com.productmapper.repositories.BaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseProductService {
    @Autowired
    private BaseProductRepository repo;

    public List<BaseProduct> getAll() {
        return repo.findAll();
    }

}
