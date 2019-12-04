package com.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;

public class Test {
	
	public static void main(String[] args) {
		String text = "[{\"fieldsname\":\"订单创建时间\",\"fieldsid\":\"order_create_time\"},{\"fieldsname\":\"申请编号\",\"fieldsid\":\"order_id\"}]";
		List<HashMap> jsonArray = JSON.parseArray(text,HashMap.class);
		System.out.println(jsonArray.get(0).keySet());
		text = "{\"fieldsname\":\"订单创建时间\",\"fieldsid\":\"order_create_time\"}";
		JSONObject jsonObject = JSONArray.parseObject(text);
		System.out.println(jsonObject.get("fieldsname"));
		
//		ArrayList<Map> list = new ArrayList<>();
		
		
//		text = "[{\"fieldsname\":\"订单创建时间\",\"fieldsid\":\"order_create_time\"},{\"fieldsname\":\"申请编号\",\"fieldsid\":\"order_id\"}]";
//		jsonArray = JSONObject.parseArray(text);
//		System.out.println(jsonArray.get(0));
		
		Field[] fieldArr = User.class.getDeclaredFields();
		User user = new User();
		user.setId(1);
		String[] interest = new String[] {"football","basketball"};
		user.setInterest(interest);
		for(Field field : fieldArr) {
			try {
				field.setAccessible(true);
				if(field.getType().isArray()) {
					System.out.println(StringUtils.join((String[]) field.get(user))+"===="+field.getGenericType());
				}
				System.out.println(field.get(user));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
