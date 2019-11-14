package com.example.mapper;

import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserMapper {
	
	User Sel(int id);

}
