package com.accper.dao;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accper.Application;
import com.accper.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTests {
	@Resource
	private UserDao userDao;
	
	@Test
    public void test() throws Exception {
        List<User> users = userDao.getAll();
        System.out.println(users.size());
    }
}
