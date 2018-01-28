package com.hytch.lfpzuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hytch.lfpzuul.exception.ResultBean;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 路由转发错误时，进行容错处理，回退异常处理
 */
@Component
@Slf4j
public class ExceptionFallback implements FallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		//输出详细的回退原因
		log.debug(cause.getMessage());
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return fallbackResponse();
		}

	}

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return response(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() {
				return status;
			}

			@Override
			public int getRawStatusCode() {
				return status.value();
			}

			@Override
			public String getStatusText() {
				return status.getReasonPhrase();
			}

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws IOException {
				ObjectMapper mapper = new ObjectMapper();
				ResultBean bean = new ResultBean();
				bean.setStatus(9999);
				bean.setMessage("系统错误，请求失败");

				String result = mapper.writeValueAsString(bean);
				return new ByteArrayInputStream(result.getBytes("UTF-8"));
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
