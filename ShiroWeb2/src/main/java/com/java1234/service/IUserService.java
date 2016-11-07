package com.java1234.service;

import java.util.Set;

import com.java1234.entity.User;

public interface IUserService {

	public User getUserByName(String userName);

	public User create(User user);
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
	
}