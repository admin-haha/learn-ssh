package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllUsers(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveUser(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/user/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUser(HttpServletRequest request,HttpServletResponse response) {
	
		return "/user/update";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.GET)
	public String toAssignRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/user/assign-role";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveUser(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateUser(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.POST)
	public void assignRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
}
