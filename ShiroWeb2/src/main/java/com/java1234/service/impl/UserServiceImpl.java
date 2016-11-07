package com.java1234.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.service.IUserService;
import com.java1234.service.PasswordHelper;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;
	@Resource
	private PasswordHelper passwordHelper;
	/* (non-Javadoc)
	 * @see com.java1234.service.impl.IUserService#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String userName){
		return userDao.findByName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		return userDao.getRoles(userName);
	}
	
	public User create(User user){
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}
	
	@Override
	public Set<String> getPermissions(String userName) {
		// TODO Auto-generated method stub
		return userDao.getPermissions(userName);
	}
	
	
}
