package com.productmapper.controller;

import com.productmapper.entities.Store;
import com.productmapper.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping("/all")
    public List<Store> getAll() {
        return service.getAll();
    }
}
