package com.example.ecommerce.CatalogueDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatalogueDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueDemoApplication.class, args);
	}

}
