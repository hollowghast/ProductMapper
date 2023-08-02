package com.productmapper.admin.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvConverterService<T> {

    char CSV_TOKEN_DELIMITER = ',';

    /**
     * reads Objects of generic type from given CSV File
     *
     * @param file file
     * @return List of generic type
     */
    List<T> readFromCSVFile(MultipartFile file);
}
