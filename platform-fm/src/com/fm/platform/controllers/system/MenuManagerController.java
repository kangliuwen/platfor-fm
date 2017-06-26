package com.fm.platform.controllers.system;

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
@RequestMapping("/menuManager")
public class MenuManagerController {
	
	@Autowired
	private MenuManagerService menuManagerService;
	@Autowired
	private UserManagerService userManagerService;
    @RequestMapping(value="/getMenus")  
    public @ResponseBody Object getMenus(HttpSession session) throws Exception{        
        User user = (User)session.getAttribute("user"); 
        int userId = user.getUserId();
        List<Menu> menuList = menuManagerService.getMenusByUserId(userId);
        //userManagerService.getUser(userCode);
        JSONObject menuJson = JsonBiz.getJsonDataForOption(menuList);
        return menuJson;
    }
}
