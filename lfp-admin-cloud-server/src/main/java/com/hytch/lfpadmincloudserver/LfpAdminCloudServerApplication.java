package com.hytch.lfpadmincloudserver;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//能够让eureka发现的客户端，要先启动eureka服务端
@EnableDiscoveryClient
@EnableAdminServer
public class LfpAdminCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfpAdminCloudServerApplication.class, args);
	}
}
