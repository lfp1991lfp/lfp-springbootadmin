package com.hytch.lfpfeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreIntegration {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "defaultStores")
	public String getStores(String name) {
		return restTemplate.getForObject("http://lfp-admin-cloud-client/api/hi?name=" + name, String.class);
	}
	
	public String defaultStores(String name) {
		return "服务器数据错误" + name;
	}
}
