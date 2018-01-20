package com.hytch.lfpadmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class LfpAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LfpAdminApplication.class, args);
	}
}
