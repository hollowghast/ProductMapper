package com.example.demo.mvc_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasicRepository extends JpaRepository<BasicObject, Long> {

    //@Query("SELECT b FROM BasicObject b WHERE b.name = ?1")
    Optional<BasicObject> findBasicByName(String name);
}
