package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/testBoot")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("getUser/{id}")
	public String GetUser(@PathVariable int id) {
		return userService.Sel(id).toString();
	}
	
	@RequestMapping("getUserByName/{name}")
	public Map<String, Object> GetUserByName(@PathVariable String name) {
		String sql = "select * from user where userName like concat('%',?,'%')  limit 1";
		Map<String, Object>  ret = jdbcTemplate.queryForMap(sql, name);
		return ret;
	}
	
	@RequestMapping("getUserByName2/{name}")
	public Integer GetUserByName2(@PathVariable String name) {
		System.out.println(name);
		String sql = "select id from user where userName like concat('%',?,'%') limit 1";
		return jdbcTemplate.queryForObject(sql, new Object[]{name},Integer.class);
	}
	
	@RequestMapping("getUserByName3/{name}")
	public Object GetUserByName3(@PathVariable String name) {
		System.out.println(name);
		name="%a%";
		String sql = "select * from user where userName like concat('%',?,'%')";
		sql = "select * from user where userName like ?";
		return jdbcTemplate.queryForList(sql, new Object[]{name});
	}
	
	@RequestMapping("getUserById/{id}")
	public Object GetUserById(@PathVariable String id) {
		id=">1";
		String sql = "select * from user where id ?";
		return jdbcTemplate.queryForList(sql, new Object[]{id});
	}
	
}
