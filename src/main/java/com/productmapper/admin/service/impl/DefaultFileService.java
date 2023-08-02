package com.productmapper.admin.service.impl;

import com.productmapper.admin.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Service
public class DefaultFileService implements FileService {
    // searches for empty rows
    private static final Pattern END_OF_TYPE = Pattern.compile("^,+$");
    private static final List<String> TYPES = List.of("address", "company", "store", "openinghours");

    @Override
    public List<File> splitInputFileByHeaders(MultipartFile inputFile) throws IOException {
        Scanner sc = new Scanner(inputFile.getInputStream());
        final List<File> files = new LinkedList<>();
        int currentType = 1;
        while (sc.hasNextLine()) {
            File file = new File(inputFile.getName() + TYPES.get(currentType++) + ".csv");
            files.add(file);
            // skip all three csv headers because we care about standards and best practices
            sc.nextLine();
            sc.nextLine();
            sc.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                String line;
                while (sc.hasNextLine() && END_OF_TYPE.matcher(line = sc.nextLine()).matches()) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return files;
    }
}
