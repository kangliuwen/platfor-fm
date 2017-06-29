package com.fm.platform.service.system;

import java.util.HashMap;
import java.util.List;

import com.fm.platform.daomain.system.Menu;

public interface MenuManagerService {

	public List<Menu> getMenusByUserId(HashMap<String, Object> paramsMap);
}
