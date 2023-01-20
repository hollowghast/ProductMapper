package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/admin", consumes = "multipart/form-data") //security needed (oauth?)
public class AdminController {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/init")
    public void addShop(@RequestParam("file") MultipartFile f){
        try {
            Shop s = service.analyzeFile(f);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
