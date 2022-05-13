package com.mysoft.lps_healthy_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {

    @Value("${file.staticPatternPath}")
    private String staticPatternPath;


    @Value("${file.uploadFolder}")
    private String uploadFolder;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticPatternPath)
                .addResourceLocations("file:"+uploadFolder);
    }
}
