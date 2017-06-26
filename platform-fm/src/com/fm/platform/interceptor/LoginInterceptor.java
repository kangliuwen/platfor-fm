package com.fm.platform.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fm.platform.daomain.system.User;
import com.fm.platform.utils.ResourcesUtil;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		String requestURI = request.getRequestURI();
		List<String> commonURLs = ResourcesUtil.gekeyList("commonURL");
		for(String commonURL:commonURLs){
			if(requestURI.indexOf(commonURL)>=0){
				return true;
			}
		}
		if ((requestURI.indexOf("index.do") >1)||requestURI.indexOf("login.do") >1) {
			return true;
		}else{
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				// 没有登陆，转向登陆界面
				request.getRequestDispatcher("/index.do").forward(request, response);
				return false;
			} else if(requestURI.indexOf(".do")<0){
				request.getRequestDispatcher("/welcome.do").forward(request, response);
				return false;
			}else{
				//有登陆，转向欢迎页面
				return true;
			}
		}
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

}
