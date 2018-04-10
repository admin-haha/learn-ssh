package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class RoleFunctionController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllRoleFunctions(HttpServletRequest request,HttpServletResponse response) {
		
		return "/role-function/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveRoleFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/role-function/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateRoleFunction(HttpServletRequest request,HttpServletResponse response) {
	
		return "/role-function/update";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveRoleFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateRoleFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}
