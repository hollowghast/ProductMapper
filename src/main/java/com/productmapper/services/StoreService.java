package com.productmapper.services;

import com.productmapper.entities.Store;
import com.productmapper.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repo;

    public List<Store> getAll() {
        return repo.findAll();
    }
}
