package com.accper.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accper.entity.User;
import com.accper.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private final static Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	List<User> getAll() {
		logger.info("the class is UserController ======> the method is getAll");
		return userService.getAll();
	}

	@RequestMapping(value = "/getOne", method = RequestMethod.POST)
	User getOne(Long id) {
		logger.info(
				"the class is UserController ======> the method is getOne, the id is {}",
				id);
		return userService.getOne(id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	void insert(User user) {
		logger.info(
				"the class is UserController ======> the method is insert, the user is {}",
				user.toString());
		userService.insert(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	void update(User user) {
		logger.info(
				"the class is UserController ======> the method is update, the user is {}",
				user.toString());
		userService.update(user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	void delete(Long id) {
		logger.info(
				"the class is UserController ======> the method is delete, the id is {}",
				id);
		userService.delete(id);
	}
	
	@RequestMapping(value = "/hello")
	public String hello(){
		return "hello world";
	}
	
	// redis 自动根据方法生成缓存
	@RequestMapping(value = "/getUser")
	@Cacheable(value = "user-key")
	public User getUser(){
		User user = userService.getOne(3L);
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}
	
	@RequestMapping(value = "/uid")
	public String uid(HttpSession session){
		UUID uid = (UUID) session.getAttribute("uid");
		if(uid == null){
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}
}
