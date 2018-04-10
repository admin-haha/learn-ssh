package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserolesController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllUseroles(HttpServletRequest request,HttpServletResponse response) {
		
		return "/useroles/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveUseroles(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/useroles/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUseroles(HttpServletRequest request,HttpServletResponse response) {
	
		return "/useroles/update";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveUser(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateUser(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}
