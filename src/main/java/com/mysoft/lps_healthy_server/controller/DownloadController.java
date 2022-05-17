package com.mysoft.lps_healthy_server.controller;

import org.apache.commons.io.IOUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequestMapping("/app")
@RestController
public class DownloadController {


    /**
     * @功能描述 下载文件:
     */
    @RequestMapping("/download")//id为要下载的图片名：123.jsp
    public void download(HttpServletRequest request, HttpServletResponse response) {


        String path = "/www/lps_healthy_app.apk";


        String name = "lps_healthy_app.apk";
        //下载
        try (InputStream inputStream = new FileInputStream(new File(path));
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + name);

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
