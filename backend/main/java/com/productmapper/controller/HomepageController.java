package com.productmapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    @GetMapping
    public String getHomepage() {
        return "forward:/html/home.html";
    }

    /*@GetMapping("/error")
    public String handlePageNotFound(){
        return "forward:/html/error/FileNotFound.html";
    }*/
}
