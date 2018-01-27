package com.hytch.lfpfeign.feign;

import org.springframework.stereotype.Component;

/**
 * 测试降级策略
 */
@Component
class SchedualServiceHiHystric implements SchedualFeignService {
	@Override
	public String sayHiFromClientOne(String name) {
		return name + ",feign，服务正在升级";
	}
}
