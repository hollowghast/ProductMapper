package com.productmapper.controller;

import com.productmapper.entities.Address;
import com.productmapper.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping(params = {"city"})
    public List<Address> getAddressesByCity(@RequestParam(name = "city") String city) {
        System.out.println("\n\n\n\n The city i chose: " + city);
        return service.getAddressesByCity(city);
    }


    @GetMapping(params = {"zipcode"})
    public List<Address> getAddressesByZipcode(@RequestParam(name = "zipcode") String zipcode) {
        System.out.println("\n\n\n\n The zipcode i chose: " + zipcode);
        return service.getAddressesByZipcode(zipcode);
    }
}
