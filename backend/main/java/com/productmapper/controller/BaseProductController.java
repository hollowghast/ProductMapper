package com.productmapper.controller;

import com.productmapper.entities.BaseProduct;
import com.productmapper.services.BaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * mapping /base_product
 */
@RestController
@RequestMapping("/base_product")
public class BaseProductController {
    @Autowired
    private BaseProductService service;

    @GetMapping("/all")
    public List<BaseProduct> getAllBaseProducts() {
        return service.getAll();
    }

}