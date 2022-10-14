package com.example.demoproduct.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File("/Users/decrises/Documents/User-Product-Demo"+file.getOriginalFilename()));
    }
}
