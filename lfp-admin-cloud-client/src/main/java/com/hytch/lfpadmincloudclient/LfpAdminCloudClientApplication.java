package com.hytch.lfpadmincloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//开启断路器装配
@EnableCircuitBreaker
//开启feign client
@EnableFeignClients
public class LfpAdminCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfpAdminCloudClientApplication.class, args);
	}
}
