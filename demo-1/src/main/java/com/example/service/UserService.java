package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	@Cacheable(cacheNames = {"user"}, key = "targetClass + methodName + #p0")
	public User Sel(int id) {
		return userMapper.Sel(id);
	}

}
