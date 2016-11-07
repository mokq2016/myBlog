package com.java1234.service;

import java.util.Set;

import com.java1234.entity.User;

public interface IUserService {

	public User getUserByName(String userName);

	public User create(User user);
	/**
	 * ͨ���û�����ѯ��ɫ��Ϣ
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * ͨ���û�����ѯȨ����Ϣ
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
	
}