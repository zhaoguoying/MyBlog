package com.Blog;

import com.Blog.mapper.*;
import com.Blog.model.User;
import com.Blog.repository.mybatis.UserRepository;
import com.Blog.service.UserService;
import com.Blog.service.security.CustomUserServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CustomUserServiceImpl customUserService;

	@Test
	public void contextLoads() {
		System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void findUserByPhone_test(){
		System.out.println(userMapper.findUserByPhone("1234567879"));
	}

	@Test
	public void getHeadPortraitUrl_Test(){
		System.out.println(userService.getHeadPortraitUrl(1));
	}

	@Test
	public void getUserPersonalInfoByUsername_Test(){
		System.out.println(userService.getUserPersonalInfoByUsername("赵国应"));
	}

	@Test
	public void findByPhone_test(){
		System.out.println(userRepository.findByPhone("1234567879"));
	}

	@Test
	public void loadUserByUsername_test(){
		System.out.println(customUserService.loadUserByUsername("1234567879"));
	}


}

