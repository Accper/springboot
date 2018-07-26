package com.accper.test;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accper.Application;
import com.accper.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		;
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testObj() throws Exception {
		User user = new User();
		user.setUserName("taoye");
		user.setPassWord("taoye2012");
		user.setUserSex("man");
		user.setNickName("板砖");
		ValueOperations<String, User> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("com.accper", user);
		opsForValue.set("com.accper.x", user,1,TimeUnit.SECONDS);
		Thread.sleep(1000);
		boolean exits = redisTemplate.hasKey("com.accper.x");
		if(exits){
			System.out.println("exits is true");
		}else{
			System.out.println("exits is false");
		}
	}
}
