package com.hytch.lfpfeign.hello.controller;

import com.hytch.lfpfeign.controller.StoreIntegration;
import com.hytch.lfpfeign.feign.SchedualFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器测试
 */
@RestController
@RequestMapping(value = "/api/")
public class HelloController {
	
	@Qualifier("schedualServiceHiHystric")
	@Autowired
	SchedualFeignService hiService;
	
	@Autowired
	StoreIntegration storeIntegration;
	
	@GetMapping(value = "hi")
	public String hello(String name) {
		return hiService.sayHiFromClientOne(name);
	}
	
	@GetMapping(value = "hi1")
	public String hello1(String name) {
		return storeIntegration.getStores(name);
	}
}
