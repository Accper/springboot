package com.accper.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accper.entity.News;


@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Resource
	private News news;
	
	@RequestMapping(value = "/world")
	@ResponseBody
	public String helloWorld(){
		logger.info("class is HelloController =====>   method is helloWorld");
		return "hello world";
	}
	
	@RequestMapping(value = "/title")
	@ResponseBody
	public String getTitle(){
		logger.info("class is HelloController =====>   method is getTitle");
		return news.getTitle()+":"+news.getContent();
	}
}
