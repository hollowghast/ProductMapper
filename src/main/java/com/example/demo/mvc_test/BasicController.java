package com.example.demo.mvc_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/basic")
public class BasicController {

    private final BasicService service;

    @Autowired
    public BasicController(BasicService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<BasicObject> getAll(){
        return service.getObjects();
    }

    @PostMapping
    public void addBasic(@RequestBody BasicObject bo)
    {
        service.addBasic(bo);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBasic(@PathVariable("id") Long id){
        service.deleteBasic(id);
    }

    @PutMapping(path = "{id}")
    public void updateBasic(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name
    ){
        service.updateBasic(id, name);
    }
}
