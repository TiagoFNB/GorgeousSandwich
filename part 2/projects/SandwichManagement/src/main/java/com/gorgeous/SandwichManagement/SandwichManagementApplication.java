package com.gorgeous.SandwichManagement;

import com.gorgeous.SandwichManagement.config.LanguageDetectorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableEurekaClient
public class SandwichManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandwichManagementApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initLanguageDetection() {
		LanguageDetectorConfig.forceInit();
	}
}
