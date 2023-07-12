package com.productmapper.controller;

import com.productmapper.admin.AdminService;
import com.productmapper.admin.services.CsvConverterService;
import com.productmapper.admin.services.implementations.DefaultCsvConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * mapping /admin
 *
 * get /test to insert test data into the database
 * post /init with a "file" attached to insert data into the database
 */
@RestController
@RequestMapping(value = "/admin") //security needed (oauth?)
public class AdminController {

    private final CsvConverterService converter;

    @Autowired
    private AdminService adminService;

    @Autowired
    public AdminController(DefaultCsvConverterService converter) {
        this.converter = converter;
    }

    @GetMapping("/test")
    public String insertTestData(){
        adminService.insertTestData();
        return "";
    }

    @PostMapping(value = "/init", consumes = "multipart/form-data", params = {"file"})
    public String addShop(@RequestParam("file") MultipartFile f) {
        Object s = converter.readFromCSVFile(f);
        if (s == null) {
            return "Error";
        } else {
            return "shop?id=626756152"; //show shop
        }
    }
}
