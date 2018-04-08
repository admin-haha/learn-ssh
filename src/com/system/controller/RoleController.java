package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/role")
public class RoleController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllRoles(HttpServletRequest request,HttpServletResponse response) {
		
		return "/role/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveRole(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/role/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/role/update";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.GET)
	public String toAssignRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/role/assign-role";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/assignFunction",method=RequestMethod.POST)
	public void assignFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}
