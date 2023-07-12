package com.productmapper.services;

import com.productmapper.entities.Address;
import com.productmapper.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService{
    @Autowired
    private AddressRepository repo;

    public Address saveAddress(Address address){
        return repo.save(address);
    }

    public Address getAddressById(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Address> getAddressesByCity(String city){
        return repo.findByCity(city);
    }
    public List<Address> getAddressesByZipcode(String zipcode){
        return repo.findByZipcode(zipcode);
    }

    public List<Address> getAllAddresses(){ return repo.findAll(); }
}
