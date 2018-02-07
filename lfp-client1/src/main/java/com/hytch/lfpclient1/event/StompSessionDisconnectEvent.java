package com.hytch.lfpclient1.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * 关闭事件监听
 */
@Slf4j
@Component
public class StompSessionDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {
	@Override
	public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
		log.debug("关闭状态编码=" + sessionDisconnectEvent.getCloseStatus().getCode());
		log.debug("关闭信息=" + sessionDisconnectEvent.getCloseStatus().getReason());
	}
}
