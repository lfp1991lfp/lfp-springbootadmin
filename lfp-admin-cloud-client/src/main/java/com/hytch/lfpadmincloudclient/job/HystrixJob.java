package com.hytch.lfpadmincloudclient.job;

import com.hytch.lfpadmincloudclient.feignclient.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 启动一个定时器，用于定时调用客户端
 */
//@Component
//@EnableScheduling
@Slf4j
public class HystrixJob {
	
	private final UserFeignClient client;
	
	@Autowired
	public HystrixJob(UserFeignClient client) {
		this.client = client;
	}
	
	//corn表达式
	@Scheduled(cron = "0/20 * * * * ?")  //每20秒执行一次
	public void doJob() {
		try {
			String result = client.user();
			log.debug("输出结果" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
