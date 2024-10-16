package com.gorgeous.PromotionManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PromotionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionManagementApplication.class, args);
	}

}
