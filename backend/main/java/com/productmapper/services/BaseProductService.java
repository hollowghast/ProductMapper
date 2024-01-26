package com.productmapper.services;

import com.productmapper.entities.BaseProduct;
import com.productmapper.constants.MassUnits;
import com.productmapper.repositories.BaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseProductService {


    @Autowired
    private BaseProductRepository repo;

    public List<BaseProduct> getAll() {
        return repo.findAll();
    }

    public BaseProduct addBaseProduct(BaseProduct baseProduct) {
        return repo.save(baseProduct);
    }

}
