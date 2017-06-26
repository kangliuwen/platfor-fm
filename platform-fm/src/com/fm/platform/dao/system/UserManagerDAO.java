package com.fm.platform.dao.system;

import java.util.HashMap;
import java.util.List;

import com.fm.platform.daomain.system.User;

public interface UserManagerDAO {

	  public abstract List<User> queryUser(HashMap<String, Object> paramHashMap);
	  public abstract User getUser(String userCode); 

}
