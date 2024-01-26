package com.productmapper.admin.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileService {

    List<File> splitInputFileByHeaders(MultipartFile file) throws IOException;
}
