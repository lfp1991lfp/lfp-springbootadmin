package com.hytch.lfpzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
//开启网关注解
@EnableZuulProxy
public class LfpZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfpZuulApplication.class, args);
	}
}
