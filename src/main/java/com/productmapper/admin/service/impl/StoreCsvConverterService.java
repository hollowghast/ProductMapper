package com.productmapper.admin.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.productmapper.admin.service.CsvConverterService;
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
public class StoreCsvConverterService implements CsvConverterService<Store> {
    @Override
    public List<Store> readFromCSVFile(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Store> csvReader = new CsvToBeanBuilder<Store>(reader)
                    .withType(Store.class)
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
