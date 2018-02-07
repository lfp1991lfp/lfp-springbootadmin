package com.hytch.lfpclient1.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

/**
 * stomp连接处理类
 * 监听用户的链接情况
 */
@Component
public class PresenceChannelInterceptor extends ChannelInterceptorAdapter {
	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		return super.preSend(message, channel);
	}
	
	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
		// ignore non-STOMP messages like heartbeat messages
		if (sha.getCommand() == null) {
			return;
		}
		super.postSend(message, channel, sent);
	}
	
	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		super.afterSendCompletion(message, channel, sent, ex);
	}
	
	@Override
	public boolean preReceive(MessageChannel channel) {
		return super.preReceive(channel);
	}
	
	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		return super.postReceive(message, channel);
	}
	
	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		super.afterReceiveCompletion(message, channel, ex);
	}
}
