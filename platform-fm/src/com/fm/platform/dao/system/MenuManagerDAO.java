package com.fm.platform.dao.system;

import java.util.HashMap;
import java.util.List;

import com.fm.platform.daomain.system.Menu;

public interface MenuManagerDAO {

	  public abstract List<Menu> getMenus(HashMap<String, Object> paramHashMap);
}
