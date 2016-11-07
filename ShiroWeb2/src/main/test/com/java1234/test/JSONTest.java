package com.java1234.test;

import com.java1234.entity.BlogType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JSONTest {
	
	public static void main(String[] agrs) {
		JSONArray jsonArray = new JSONArray(); 
		BlogType btype = new BlogType();
		btype.setId(1);
		btype.setTypeName("hha");
		
		JSONObject json = JSONObject.fromObject(btype);
		
		jsonArray.add(json);
		System.out.println(jsonArray.toString());
	}
}
