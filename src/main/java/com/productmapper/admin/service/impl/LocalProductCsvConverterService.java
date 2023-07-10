package com.productmapper.admin.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.productmapper.admin.service.CsvConverterService;
import com.productmapper.entities.LocalProduct;
import com.productmapper.entities.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
public class LocalProductCsvConverterService implements CsvConverterService<LocalProduct> {
    @Override
    public List<LocalProduct> readFromCSVFile(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<LocalProduct> csvReader = new CsvToBeanBuilder<LocalProduct>(reader)
                    .withType(LocalProduct.class)
                    .withSeparator(CSV_TOKEN_DELIMITER)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            return csvReader.parse();
        } catch (IOException e) {
            System.err.println("parsing csv file failed");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
