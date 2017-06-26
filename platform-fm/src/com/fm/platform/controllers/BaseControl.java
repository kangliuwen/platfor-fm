package com.fm.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseControl {

	@RequestMapping("/hello")
	public String test(){
		return "hello";
	}
}
