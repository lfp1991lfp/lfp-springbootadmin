package com.hytch.lfpclient1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * websocket配置
 * <p>
 * webSocket的配置类
 * EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
 * registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL
 * stompEndpointRegistry.addEndpoint("/lfp").withSockJS();这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。
 * configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//websocket的端点，客户端需要注册这个端点进行链接,withSockJS允许客户端利用sockjs进行浏览器兼容性处理
		stompEndpointRegistry.addEndpoint("/lfp").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//推送全局消息前缀(在topic和user这两个域上可以向客户端发消息)
		registry.enableSimpleBroker("/topic", "/user");
		//设置客户端订阅消息的基础路径,设置移动端和web端（应用消息前缀）
		registry.setApplicationDestinationPrefixes("/app", "/web_client");
		//推送用户前缀
		registry.setUserDestinationPrefix("/user");
	}
	
	/**
	 * 链接进来的消息,都走这个方法体.
	 *
	 * @param registration 管道注册
	 */
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.taskExecutor().corePoolSize(4) //设置消息输入通道的线程池线程数
				.maxPoolSize(8)//最大线程数
				.keepAliveSeconds(60);//线程活动时间
		registration.interceptors(presenceChannelInterceptor());
	}
	
	/**
	 * 输出的消息都走这个方法体
	 *
	 * @param registration 管道注册
	 */
	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		registration.taskExecutor().corePoolSize(4).maxPoolSize(8);
		registration.interceptors(presenceChannelInterceptor());
	}
	
	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
		registration.setMessageSizeLimit(8192) //设置消息字节数大小
				.setSendBufferSizeLimit(8192)//设置消息缓存大小
				.setSendTimeLimit(10000); //设置消息发送时间限制毫秒
	}
	
	@Bean
	public PresenceChannelInterceptor presenceChannelInterceptor() {
		return new PresenceChannelInterceptor();
	}
}
