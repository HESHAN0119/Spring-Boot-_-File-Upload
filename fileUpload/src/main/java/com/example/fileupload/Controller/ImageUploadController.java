package com.example.fileupload.Controller;

import com.example.fileupload.Util.FileUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@RequestMapping("api/v1/img")
@RestController
public class ImageUploadController {

    @PostMapping("/upload")
    public void saveImage(@RequestParam("files")MultipartFile[] files){
    String uploadDir="ProfileUploadFolder";
        Arrays.asList(files).stream().forEach(file ->{
            String filename= StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            System.out.println(filename);
            FileUploadUtil.saveFile(uploadDir,filename,file);

        });
    }

}
