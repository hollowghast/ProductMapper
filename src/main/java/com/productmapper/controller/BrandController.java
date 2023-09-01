package com.productmapper.controller;

import com.productmapper.entities.Brand;
import com.productmapper.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/all")
    public List<Brand> getAll() {
        return service.getAll();
    }
}
