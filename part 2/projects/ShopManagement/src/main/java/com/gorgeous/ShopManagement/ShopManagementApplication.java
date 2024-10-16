package com.gorgeous.ShopManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopManagementApplication.class, args);
    }
}
