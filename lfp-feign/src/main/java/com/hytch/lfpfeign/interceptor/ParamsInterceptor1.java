package com.hytch.lfpfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 参数拦截器.
 * 用于数据拦截，提供参数转变
 */
public class ParamsInterceptor1 implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {
		requestTemplate.header("X-Forwarded-For", "test");
	}
}
