package com.hytch.lfpclient1.wscontroller.service;

import com.hytch.lfpclient1.wscontroller.model.RequestClientMessage;
import com.hytch.lfpclient1.wscontroller.model.ResponseClientMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * webservice，服务层
 */
@Service
public class WebSocketService {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	/**
	 * 广播
	 * 发给所有在线用户
	 *
	 * @param request
	 */
	public ResponseClientMessage sendAll(RequestClientMessage request) {
		return new ResponseClientMessage("welcome," + request.getName() + " !");
	}
	
	/**
	 * 发送给指定用户
	 *
	 * @param userName 用户名
	 */
	public ResponseClientMessage sendToUsers(String userName) {
		return new ResponseClientMessage(userName + "收到消息");
	}
	
	/**
	 * 发送给指定用户
	 *
	 * @param userName 用户名
	 */
	public void send2Users(String userName) {
		ResponseClientMessage msg = new ResponseClientMessage(userName + "收到消息");
		template.convertAndSendToUser(userName, "/message", msg);
	}
}
