package com.fm.platform.daomain.system;

import java.util.List;

public class Menu {

	public int menuId;
	public String menuName;
	public String URL;
	public String isUse;
	public String userId;
	private List<Menu> childrenMenu; 
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public List<Menu> getChildrenMenu() {
		return childrenMenu;
	}
	public void setChildrenMenu(List<Menu> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
