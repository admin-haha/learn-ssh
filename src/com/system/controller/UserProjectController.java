package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userProject")
public class UserProjectController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllUserProjects(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user-project/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/user-project/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		return "/user-project/update";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
}
