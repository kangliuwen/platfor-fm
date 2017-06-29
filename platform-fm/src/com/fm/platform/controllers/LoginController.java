package com.fm.platform.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fm.platform.daomain.system.Menu;
import com.fm.platform.daomain.system.User;
import com.fm.platform.service.system.MenuManagerService;
import com.fm.platform.service.system.UserManagerService;
import com.fm.platform.utils.JsonBiz;
@Controller
public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserManagerService userManagerService;
	@Autowired
	private MenuManagerService menuManagerService;
	  /**
	   * 登陆系统
	   * @param session
	   * @param username
	   * @param password
	   * @return
	   * @throws Exception
	   */
    @RequestMapping(value="/login")  
    public @ResponseBody Object login(HttpSession session,String userName,String password) throws Exception{        
    	if(userName!=null&&!userName.equals("")){
    		User user = userManagerService.getUser(userName);
        	if(user!=null&&user.getPassword().equals(password)){
                session.setAttribute("user", user);  
                return JsonBiz.isSucceed(true, "登陆成功！");
        	}
    	}
    	return JsonBiz.isSucceed(false,"用户名或密码错误！");
    }  
      
    /** 
     * 退出系统 
     * @param session 
     *          Session 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value="/logout")  
    public String logout(HttpSession session) throws Exception{  
        //清除Session  
        session.invalidate();  
        return "login/index";  
    }
    
    @RequestMapping(value="/index")  
    public String index(){
    	return "login/index";
    }
    @RequestMapping(value="/welcome")  
    public String welocme(HttpSession session){
    	
    	HashMap<String,Object> paramsMap = new HashMap<String,Object>();
    	User user = (User)session.getAttribute("user");
    	paramsMap.put("userId", user.getUserId());
    	paramsMap.put("type", "menu");
        List<Menu> menuList = menuManagerService.getMenusByUserId(paramsMap);
        JSONObject menuJson = JsonBiz.getJsonDataForOption(menuList);
    	session.setAttribute("version_number", "V1.0");
    	session.setAttribute("version_date", "2017-06-20");
    	session.setAttribute("menus", menuJson);
    	return "login/welcome";
    }
    @RequestMapping(value="/fist")
    public String fist(){
    	
    	return "first";
    }
}
