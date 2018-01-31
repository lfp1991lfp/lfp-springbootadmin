package com.hytch.lfpclient1.wscontroller.controller;

import com.hytch.lfpclient1.wscontroller.model.RequestClientMessage;
import com.hytch.lfpclient1.wscontroller.model.ResponseClientMessage;
import com.hytch.lfpclient1.wscontroller.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * webSocket控制层
 */
@Controller
public class WsController {
	
	@Autowired
	WebSocketService webSocketService;
	
	/**
	 * MessageMapping表示消息映射的URL路径,
	 * SendTo注解表示当服务器有消息需要推送的时候,
	 * 会对订阅了@SendTo中路径的浏览器发送消息
	 */
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public ResponseClientMessage say(RequestClientMessage message) {
		System.out.println(message.getName());
		return webSocketService.sendAll(message);
	}
	
	@MessageMapping("/sendToUser1")
	@SendToUser("/message")
	public ResponseClientMessage sendToUser1(RequestClientMessage message) {
		return webSocketService.sendToUsers(message.getName());
	}
	
	@MessageMapping("/sendToUser")
	public void sendToUser(RequestClientMessage message) {
		webSocketService.send2Users(message.getName());
	}
}
