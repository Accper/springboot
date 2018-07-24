package com.accper.dao;


import com.accper.entity.User;

public interface UserDao {
	User findByUserName(String userName);
	User findByUserNameOrEmail(String username, String email);
}
