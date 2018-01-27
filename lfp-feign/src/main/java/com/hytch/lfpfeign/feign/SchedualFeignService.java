package com.hytch.lfpfeign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用其它服务的接口
 * name 表示找到对应服务暴露的接口，也表示自己的服务名称
 * <p>
 * fallback = SchedualServiceHiHystric.class
 * fallbackFactory = SchedualServiceHiHystricFactory.class
 */
@Service(value = "schedualFeignService")
@FeignClient(
		name = "lfp-admin-cloud-client",
		qualifier = "schedualFeignService",
		fallbackFactory = SchedualServiceHiHystricFactory.class)
public interface SchedualFeignService {
	//@RequestParam一定要配置
	//其他服务暴露的接口
	@GetMapping(value = "/api/hi")
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
