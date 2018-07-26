package com.accper.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accper.dao.UserDao;
import com.accper.entity.User;

@Service
public class UserService {

	@Resource
	private UserDao userDao;

	public List<User> getAll() {
		return userDao.getAll();
	}

	public User getOne(Long id) {
		return userDao.getOne(id);
	}

	public void insert(User user) {
		userDao.insert(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(Long id) {
		userDao.delete(id);
	}
}
