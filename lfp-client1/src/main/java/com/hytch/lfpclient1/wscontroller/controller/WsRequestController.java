package com.hytch.lfpclient1.wscontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsRequestController {
	
	@RequestMapping(value = "/ws")
	public String ws() {
		return "/ws";
	}
}
