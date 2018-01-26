package com.hytch.lfpfeign.feign;

/**
 * 测试降级策略
 */
class SchedualServiceHiHystric implements SchedualFeignService {
	@Override
	public String sayHiFromClientOne(String name) {
		return name + ",feign，服务正在升级";
	}
}
