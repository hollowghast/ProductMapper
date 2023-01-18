package com.example.demo.mvc_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BasicService {

    private final BasicRepository repo;

    @Autowired
    public BasicService(BasicRepository repo) {
        this.repo = repo;
    }

    public List<BasicObject> getObjects(){
        return repo.findAll();
    }

    public void addBasic(BasicObject bo){
        if(
                repo.findBasicByName(bo.getName()).isPresent()
        ) throw new IllegalStateException("Name already in use.");

        repo.save(bo);
    }

    public void deleteBasic(Long id){
        if(repo.existsById(id))
            repo.deleteById(id);
        else throw new IllegalStateException("Id does not exist");
    }

    @Transactional
    public void updateBasic(Long id, String name){
        BasicObject bo = repo.findById(id).orElseThrow(
                () -> new IllegalStateException("Id does not exist")
        );

        if(name != null && name.length() > 0 &&
        !Objects.equals(bo.getName(), name)){
            bo.setName(name);
        }

    }
}
