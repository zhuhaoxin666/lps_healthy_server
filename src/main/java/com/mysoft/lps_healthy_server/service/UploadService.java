package com.mysoft.lps_healthy_server.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadService {


    @Value("${file.staticPatternPath}")
    private String staticPatternPath;

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Value("${file.staticPath}")
    private String staticPath;

    private String dir = "hosImages";


    public String uploadImg(MultipartFile multipartFile) {

        try {
            String realFileName = multipartFile.getOriginalFilename();
            String imgSuffix = realFileName.substring(realFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + imgSuffix;
            String serverPath = uploadFolder;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());

            File targetPath = new File(serverPath + dir, datePath);
            if (!targetPath.exists()) {
                targetPath.mkdirs();
            }

            File targetFileName = new File(targetPath, newFileName);
            multipartFile.transferTo(targetFileName);
            String fileName = dir + "/" + datePath + "/" + newFileName;
            return staticPath + "uploadImg/" + fileName;

        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
