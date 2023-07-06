package com.productmapper.admin;

import com.productmapper.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/admin", consumes = "multipart/form-data") //security needed (oauth?)
public class AdminController {

    private final CsvConverterService converter;

    @Autowired
    public AdminController(CsvConverterService converter) {
        this.converter = converter;
    }

    @PostMapping("/init")
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
