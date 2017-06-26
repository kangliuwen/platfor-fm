package com.fm.platform.service.system;

import java.util.HashMap;
import java.util.List;
import com.fm.platform.daomain.system.User;

public interface UserManagerService {

	  public abstract List<User> queryUser(HashMap<String, Object> paramHashMap);
	  public abstract User getUser(String userCode);
}
