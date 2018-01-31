package com.hytch.lfpclient1.wscontroller.model;

import lombok.Data;

/**
 * 收到浏览器（客户端）的请求消息model
 */
@Data
public class RequestClientMessage {
	private String name;
}
