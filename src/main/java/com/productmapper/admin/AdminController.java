package com.productmapper.admin;

import com.productmapper.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public AdminController(CsvConverterService converter) {
        this.converter = converter;
    }

    @GetMapping("/test")
    public String insertTestData(){
        adminService.insertTestData();
        return "";
    }

    @PostMapping(value = "/init", consumes = "multipart/form-data", params = {"file"})
    public String addShop(@RequestParam("file") MultipartFile f){
        try {
            Store s = converter.analyzeFile(f);
            if(s == null){
                return "Error";
            }
            else return "shop?id=626756152"; //show shop
        }catch (IOException ioe){
            ioe.printStackTrace(); //log
        }catch(Exception e){
            e.printStackTrace(); //log
        }
        return "somethingWentWrong";
    }
}
