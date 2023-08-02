package com.productmapper.admin;

import com.productmapper.admin.service.CsvConverterService;
import com.productmapper.admin.service.impl.StoreCsvConverterService;
import com.productmapper.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/admin") //security needed (oauth?)
public class AdminController {

    private final CsvConverterService<Store> converter;

    @Autowired
    private AdminService adminService;

    @Autowired
    public AdminController(StoreCsvConverterService converter) {
        this.converter = converter;
    }

    @GetMapping("/test")
    public String insertTestData() {
        adminService.insertTestData();
        return "";
    }

    @PostMapping(value = "/init", consumes = "multipart/form-data")
    public String addShop(@RequestParam("file") MultipartFile f) {
        //  try {
        List<Store> s = converter.readFromCSVFile(f);
        if (s == null) {
            return "Error";
        } else {
            return "shop?id=626756152"; //show shop
        }
        /* }catch (IOException ioe){
            ioe.printStackTrace(); //log
        }catch(Exception e){
            e.printStackTrace(); //log
        }
        return "somethingWentWrong";*/
    }
}
