package com.hytch.lfpadmincloudclient.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 获取用户的远程信息客户端
 */
@FeignClient(name = "user-service", url = "http://localhost:8002/metrics")
public interface UserFeignClient {
	//访问地址是/user，和springmvc类似
	@GetMapping(name = "/user")
	String user();
}
