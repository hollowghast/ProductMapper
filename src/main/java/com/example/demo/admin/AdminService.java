package com.example.demo.admin;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class AdminService {
    public Shop analyzeFile(MultipartFile f) throws UnsupportedOperationException, IOException {
        //file -> shop
        if (f.getResource().exists()) {
            if (f.getResource().isReadable()) {
                //switch file types
                String fname = f.getResource().getFilename();
                String ending = fname.substring(fname.lastIndexOf((int) '.') + 1 /* dont need the dot */);
                System.out.println("Preparing to analyze " + fname);

                if(ending.toLowerCase().equals("csv")){
                    throw new UnsupportedOperationException("not done yet");
                }
            }
        }
        return null;
    }

    private Map mapFileContents(MultipartFile f){
        return null;
    }
}
