package com.hytch.lfpribbon.hello.controller;

import com.hytch.lfpribbon.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器测试
 */
@RestController
@RequestMapping(value = "/order/")
public class HelloController {
	
	@Autowired
	HelloService service;
	
	@GetMapping(value = "hi")
	public String hello(String name) {
		return service.hiService(name);
	}
}
