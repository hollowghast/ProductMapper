package com.productmapper.admin;

import com.productmapper.entities.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

@Service
public class CsvConverterService {
    private final static String CSV_TOKEN_DELIMITER = ",";

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
            tokens = fin.nextLine().trim().split(CSV_TOKEN_DELIMITER);
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
