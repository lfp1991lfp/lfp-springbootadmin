package com.hytch.lfpzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * 路由转发控制器，zuul控制器，进行基本的控制验证
 * How to Write a Pre Filter
 * http://cloud.spring.io/spring-cloud-static/Edgware.RELEASE/single/spring-cloud.html#netflix-zuul-starter
 */
@Slf4j
@Component
public class TokenFilter extends ZuulFilter {
	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * filterOrder：过滤的顺序
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 *
	 * @return 见上述内容
	 */
	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
				&& !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getParameter("token") != null) {
			// put the serviceId in `RequestContext`
			ctx.put(SERVICE_ID_KEY, request.getParameter("foo"));
		}
		return null;
	}
}
