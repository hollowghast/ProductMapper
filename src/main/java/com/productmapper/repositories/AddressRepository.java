package com.productmapper.repositories;

import com.productmapper.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{
    //@Query("SELECT a FROM address a WHERE a.zipcode = :zip") //ERROR
    List<Address> findByZipcode(@Param("zip") String zip);

    //@Query(value = "SELECT * FROM address WHERE city = :city", nativeQuery = true)
    List<Address> findByCity(@Param("city") String city);
}
