package com.example.demo.admin;

import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.io.File;

@Service
public class AdminService {
    public Shop analyzeFile(File f) throws UnsupportedOperationException
    {
        //file -> shop
        if(f.exists()){
            if(f.canRead()){
                //switch file types
                String fname = f.getName();
                String ending = fname.substring(fname.lastIndexOf((int) '.'));
                System.out.println(ending);
                switch(ending){
                    case "txt":
                        throw new UnsupportedOperationException("txt files not supported yet");
                    case "xlsx":
                        throw new UnsupportedOperationException("excel files not supported yet");
                    case "csv":
                        throw new UnsupportedOperationException("csv files not supported yet");
                    case "odf":
                        throw new UnsupportedOperationException("odf files not supported yet");
                }
            }
        }
        return null;
    }
}
