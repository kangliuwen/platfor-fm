package com.fm.platform.service.system.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fm.platform.dao.system.MenuManagerDAO;
import com.fm.platform.daomain.system.Menu;
import com.fm.platform.service.system.MenuManagerService;

@Service
public class MenuManagerServiceImpl implements MenuManagerService {

	@Autowired
	private MenuManagerDAO menuManagerDAO;
	@Override
	public List<Menu> getMenusByUserId(HashMap<String, Object> paramsMap) {
		List<Menu> listMenu = menuManagerDAO.getMenus(paramsMap);
		return listMenu;
	}
	@Override
	public Menu getMenuById(HashMap<String, Object> paramsMap) {
		Menu menu = menuManagerDAO.getMenuById(paramsMap);
		return menu;
	}

}