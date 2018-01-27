package com.hytch.lfpfeign.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystricFactory implements FallbackFactory<SchedualFeignService> {
	
	@Override
	public SchedualFeignService create(Throwable cause) {
		return name -> name + "fallback; reason was: " + cause.getMessage();
	}
}
