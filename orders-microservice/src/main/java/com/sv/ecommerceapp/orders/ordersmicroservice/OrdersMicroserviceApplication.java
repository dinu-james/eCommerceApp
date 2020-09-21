package com.sv.ecommerceapp.orders.ordersmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrdersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersMicroserviceApplication.class, args);
	}

}
