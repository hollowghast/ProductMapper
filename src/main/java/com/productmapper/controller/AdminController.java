package com.productmapper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productmapper.admin.AdminService;
import com.productmapper.entities.BaseProduct;
import com.productmapper.services.BaseProductService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @Autowired
    private BaseProductService baseProductService;

    @GetMapping("/test")
    public String insertTestData() {
        adminService.insertTestData();
        return "";
    }

    @PostMapping(value = "/addShop", consumes = "multipart/form-data", params = {"file"})
    public void importShop(@RequestParam("file") MultipartFile file) {
        adminService.importStore(file);
    }

    @GetMapping(value = "/indexData")
    public void indexData(@RequestParam Long id) throws SolrServerException, IOException {
        adminService.indexProductForCode(id);
    }

    @PostMapping(value = "/addProduct",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@RequestBody String productJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BaseProduct product = objectMapper.readValue(productJson, BaseProduct.class);
        baseProductService.addBaseProduct(product);
    }
}
