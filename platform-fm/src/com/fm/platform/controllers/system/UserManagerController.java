package com.fm.platform.controllers.system;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.fm.platform.daomain.system.User;
import com.fm.platform.service.system.UserManagerService;

@Controller
public class UserManagerController {
	
	@Autowired
	private UserManagerService userManagerService;
	@RequestMapping("getUserList")
	public ModelAndView queryUserList(HttpServletRequest request){
		HashMap<String, Object> paramMap = new HashMap<String,Object>();
		List<User> listUser = userManagerService.queryUser(paramMap);
		  ModelAndView mav = new ModelAndView();
		  mav.addObject("listUser",listUser);
		  mav.setViewName("userList");
		return mav;
	}
}
