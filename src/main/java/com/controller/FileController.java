package com.controller;

import com.model.File;
import com.model.Home;
import com.service.FileService;
import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth/file")
public class FileController {
    @Autowired
    Environment env;
    @Autowired
    FileService fileService;
    @Autowired
    HomeService homeService;
    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@RequestParam("name") MultipartFile file,@PathVariable Long id) throws IOException{
        Optional<Home> home = homeService.findById(id);
        File file1 = new File();
        String fileName = file.getOriginalFilename();
        String fileUpload = env.getProperty("uploadPath").toString();
        if(!fileName.equals("")){
            FileCopyUtils.copy(file.getBytes(),new java.io.File(fileUpload + fileName));
            file1.setPath("http://localhost:8080/auth/api/file/");
            file1.setName(fileName);
        }
        file1.setHome(home.get());
        fileService.save(file1);

        return new ResponseEntity<>(file1,HttpStatus.OK);
    }
}
