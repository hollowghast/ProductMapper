package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/admin") //security needed (oauth?)
public class AdminController {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/init")
    public void addShop(@RequestBody MultipartFile f){
        System.out.println(f.getName());
        //Shop s = service.analyzeFile(f);
    }
}
