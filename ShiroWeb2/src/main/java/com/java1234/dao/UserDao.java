package com.java1234.dao;

import java.util.Set;

import com.java1234.entity.User;

public interface UserDao {
	
	public int add(User user);
	
	public int update(User user);
	
	public User findByName(String userName);
	
	public Set<String> getRoles(String userName);
	
	public Set<String> getPermissions(String userName);
	
	public User createUser(User user);
}
