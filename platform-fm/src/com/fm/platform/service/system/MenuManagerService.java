package com.fm.platform.service.system;

import java.util.List;

import com.fm.platform.daomain.system.Menu;

public interface MenuManagerService {

	public List<Menu> getMenusByUserId(int userId);
}
