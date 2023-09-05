package com.productmapper.controller;

import com.productmapper.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * mapping /admin
 * <p>
 * get /test to insert test data into the database
 * post /init with a "file" attached to insert data into the database
 */
@RestController
@RequestMapping(value = "/admin") //security needed (oauth?)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/test")
    public String insertTestData() {
        adminService.insertTestData();
        return "";
    }

    @PostMapping(value = "/addShop", consumes = "multipart/form-data", params = {"file"})
    public void importShop(@RequestParam("file") MultipartFile file) {
        adminService.importStore(file);
    }
}
