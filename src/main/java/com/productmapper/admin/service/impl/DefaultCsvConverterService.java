package com.productmapper.admin.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.productmapper.admin.service.CsvConverterService;
import com.productmapper.entities.LocalProduct;
import com.productmapper.entities.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Service
public class DefaultCsvConverterService implements CsvConverterService {
    private final static char CSV_TOKEN_DELIMITER = ',';

    @Override
    public List<LocalProduct> readProductsFromCsvFile(MultipartFile file) {
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

    @Override
    public Store readStoreFromCsvFile(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Store> csvReader = new CsvToBeanBuilder<Store>(reader)
                    .withType(Store.class)
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
    }

    public Store analyzeFile(MultipartFile f) throws UnsupportedOperationException, IOException {
        //file -> shop
        if (f.getResource().exists()) {
            if (f.getResource().isReadable()) {
                //switch file types
                String fname = f.getResource().getFilename();
                String ending = fname.substring(fname.lastIndexOf((int) '.') + 1 /* dont need the dot */);
                System.out.println("Preparing to analyze " + fname);

                if (ending.toLowerCase().equals("csv")) {
                    //throw new UnsupportedOperationException("not done yet");
                    convert(f);
                }
            }
        }
        return null;
    }

    private Store convert(MultipartFile f) throws IOException {
        Scanner fin = new Scanner(f.getInputStream());
        String[] tokens;

        /*
        a) split [main headers] from [inventory and coupons]
        b) extract main headers
        c) split inventory from coupons
        d) extract inventory headers
        e) extract inventory data
        f) extract coupon headers
        g) extract coupon data
         */

        //a)
        Map<String, String> mainHeader = new HashMap<>();

        Stream<String> s = fin.findAll(".+") //forms stream of all non-empty lines from the file
                .map(m -> m.group().trim())
                .filter(l -> l.length() > 0);

        //s.limit(2).

        for (int i = 0; fin.hasNextLine(); i++) {
            tokens = fin.nextLine().trim().split("" + CSV_TOKEN_DELIMITER);
            if (tokens.length > 0) {
                if (mainHeader.isEmpty()) {
                    /*mainHeader.putAll(
                            Arrays.asList(tokens)
                                    .stream()
                                    .collect(Collectors.toMap(t -> t, ""))
                    );*/
                }
            } else {
                i--;
                continue;
            }

        }

        fin.close();
        return null;
    }
}
