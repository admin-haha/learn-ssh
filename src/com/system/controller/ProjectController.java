package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllProjects(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveProject(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/project/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateProject(HttpServletRequest request,HttpServletResponse response) {
	
		return "/project/update";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
}
