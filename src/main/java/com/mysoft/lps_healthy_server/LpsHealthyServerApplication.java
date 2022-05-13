package com.mysoft.lps_healthy_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LpsHealthyServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LpsHealthyServerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
