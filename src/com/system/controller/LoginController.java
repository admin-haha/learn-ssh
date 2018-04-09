package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response) {
		
		
		return "/login";
	}
	
	//非法登录，直接返回至登录页
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String illegalLogin(final HttpServletRequest request) {
		return  "redirect:/login.jsp";
	}
	//不接收Get请求
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(final HttpServletRequest request, final HttpServletResponse response,
			final ModelMap context, final Integer ownerId, final String account,
			final String password, final String loginUrl, final String yanZhengMa,final String tenantCode) {

		return "redirect:/index";

	}

	@RequestMapping(value = "/logout")
	public String logout(final HttpServletRequest request, final HttpServletResponse response) {
		return "/session_error";
	}
}
