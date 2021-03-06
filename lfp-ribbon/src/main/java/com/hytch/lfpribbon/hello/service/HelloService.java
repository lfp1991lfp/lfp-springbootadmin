package com.hytch.lfpribbon.hello.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试服务
 */
@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;
	
	//对应断路器处理，若是服务找不到，则找到对应的降级策略
	@HystrixCommand(fallbackMethod = "error")
	public String hiService(String name) {
		return restTemplate.getForObject("http://lfp-admin-cloud-client/api/hi?name=" + name, String.class);
	}
	
	public String error(String name) {
		return name + "数据正在升级";
	}
}
