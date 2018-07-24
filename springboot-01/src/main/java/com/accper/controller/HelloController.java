package com.accper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	
	@RequestMapping(value = "/world")
	@ResponseBody
	public String helloWorld(){
		return "hello world";
	}
}
