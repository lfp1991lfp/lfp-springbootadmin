package com.hytch.lfpeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LfpEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfpEurekaServerApplication.class, args);
	}
}
