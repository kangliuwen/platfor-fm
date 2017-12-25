package com.fm.platform.controllers.system;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fm.platform.daomain.system.Menu;
import com.fm.platform.daomain.system.User;
import com.fm.platform.service.system.MenuManagerService;
import com.fm.platform.service.system.UserManagerService;
import com.fm.platform.utils.JsonBiz;

@Controller
@RequestMapping("/user")
public class UserManagerController {
	
	@Autowired
	private UserManagerService userManagerService;
	@Autowired
	private MenuManagerService menuManagerService;
	
	@RequestMapping("/userManager")
	public ModelAndView queryUserList(HttpServletRequest request,HttpSession session){
		HashMap<String, Object> paramMap = new HashMap<String,Object>();
		List<User> listUser = userManagerService.queryUser(paramMap);
		  ModelAndView mav = new ModelAndView();
		  mav.addObject("listUser",listUser);
		  mav.setViewName("userList");
	      session.setAttribute("roleList", "FE:1;IN:2;TN:3;AR:4");

		return mav;
	}
	@RequestMapping("/query")
	public String query(HttpServletRequest request,HttpSession session){
        User user = (User)session.getAttribute("user"); 
        int userId = user.getUserId();
        HashMap<String,Object> paramsMap = new HashMap<String,Object>();
        paramsMap.put("userId", userId);
        paramsMap.put("type", "permission");
        paramsMap.put("percode", "user");
        List<Menu> menuList = menuManagerService.getMenusByUserId(paramsMap);
        request.setAttribute("menuList", menuList);
		return "/user/userList";
	}
    @RequestMapping("/queryJson")  
    public @ResponseBody Object queryJson(HttpSession session) throws Exception{        
		HashMap<String, Object> paramMap = new HashMap<String,Object>();
		List<User> listUser = userManagerService.queryUser(paramMap);
		int count = userManagerService.getuserCount(paramMap);
        JSONObject userListJson = JsonBiz.getJsonDataForEasyUi(listUser,count);
        return userListJson;
    }
}
