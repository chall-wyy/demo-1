package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User Sel(int id) {
		return userMapper.Sel(id);
	}

}
