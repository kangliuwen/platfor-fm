package com.fm.platform.service.system.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.platform.dao.system.UserManagerDAO;
import com.fm.platform.daomain.system.User;
import com.fm.platform.service.system.UserManagerService;
@Service("userManagerService")
public class UserManagerServiceImpl implements UserManagerService{

	@Autowired
	private UserManagerDAO userManagerDAO;
	@Override
	public List<User> queryUser(HashMap<String, Object> paramHashMap) {
		return userManagerDAO.queryUser(paramHashMap);
	}
	@Override
	public User getUser(String userCode) {
		return userManagerDAO.getUser(userCode);
	}

}
