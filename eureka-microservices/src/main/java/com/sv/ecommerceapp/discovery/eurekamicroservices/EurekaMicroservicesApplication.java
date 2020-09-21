package com.sv.ecommerceapp.discovery.eurekamicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMicroservicesApplication.class, args);
	}

}
