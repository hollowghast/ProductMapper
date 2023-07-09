package com.productmapper.admin.service;

import com.productmapper.entities.Local_Product;
import com.productmapper.entities.Store;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvConverterService {

    /**
     * reads Products from given CSV File
     *
     * @param file file
     * @return List of Local_Product
     */
    List<Local_Product> readProductsFromCsvFile(MultipartFile file);

    /**
     * reads Store from CSV File
     *
     * @param file file
     * @return Store
     */
    Store readStoreFromCsvFile(MultipartFile file);
}
