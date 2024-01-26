package com.productmapper.admin.services.implementations;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.productmapper.admin.services.CsvConverterService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultCsvConverterService<T> implements CsvConverterService<T> {

    @Override
    public List<T> readFromCSVFile(MultipartFile file/*, Class<T> type*/) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    //.withType(type)
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

    /*@Override
    public T readObjectFromCSVFile(MultipartFile file, Class<T> type) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withType(type)
                    .withSeparator(CSV_TOKEN_DELIMITER)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            return csvReader.parse()
                    .stream()
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.err.println("parsing csv file failed");
            e.printStackTrace();
            return null;
        }
    }*/
}
