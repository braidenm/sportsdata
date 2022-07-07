package com.braidenmiller.sportsdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.braidenmiller.sportsdata")
public class SportsdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsdataApplication.class, args);
    }

}
