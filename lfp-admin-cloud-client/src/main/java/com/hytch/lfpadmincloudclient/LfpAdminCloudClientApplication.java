package com.hytch.lfpadmincloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
//开启feign client
@EnableFeignClients
public class LfpAdminCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfpAdminCloudClientApplication.class, args);
	}
}
