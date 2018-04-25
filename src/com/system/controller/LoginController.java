package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.constant.Constant;
import com.system.po.RoleFunction;
import com.system.po.Roles;
import com.system.po.Useroles;
import com.system.po.Users;
import com.system.service.RolesService;
import com.system.service.UserService;
import com.system.service.UserolesService;
import com.system.utils.WebHelper;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserolesService userolesService;
	@Autowired
	private RolesService rolesService;
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap context) {
		context.addAttribute("notices", userService.queryAllNotice());
		
		return "/index";
	}
	
	//非法登录，直接返回至登录页
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String illegalLogin(final HttpServletRequest request,ModelMap context) {
		context.addAttribute("notices", userService.queryAllNotice());
		return  "/login";
	}
	//不接收Get请求
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login( HttpServletRequest request,  HttpServletResponse response,
			 ModelMap context,  Integer ownerId, String account, String password,  String loginUrl,  String yanZhengMa) {

		//校验人员
		Users vo = null;
		try {
			vo = userService.queryByAccountAndPassword(account, password);
		}catch(Exception e) {
			
		}
		if(vo==null) {
			context.addAttribute("notices", userService.queryAllNotice());
			context.addAttribute("error","人员登录信息有误！");
			return "/login";
		}
		request.getSession().setAttribute(Constant.SESSION_KEY, vo);
		//人员角色
		Useroles useroles = userolesService.queryByUserId(vo.getId());
		if(useroles!=null) {
			Roles roles = rolesService.queryById(useroles.getRoleId());
			context.addAttribute("roleId", roles!=null?roles.getId():"-1");
			context.addAttribute("roleName", roles!=null?roles.getName():"");
		}
		
		context.addAttribute("user",vo);
		//WebHelper.sendData(response, "{'flag':'0','msg':'保存成功'}");
		
		return "/index";

	}

	@RequestMapping(value = "/logout")
	public String logout(final HttpServletRequest request, final HttpServletResponse response) {
		return "/session_error";
	}
}
