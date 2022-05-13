package com.mysoft.lps_healthy_server.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("/word")
    public Map<String,User> Hello() {
        Map<String,User> map = new HashMap<>();
        map.put("Stirng",new User("zhangsan",14));
        return map;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User {
        String name;
        Integer id;
    }
}
