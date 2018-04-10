package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllDepartments(HttpServletRequest request,HttpServletResponse response) {
		
		return "/department/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveDepartment(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/department/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateDepartment(HttpServletRequest request,HttpServletResponse response) {
	
		return "/department/update";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveDepartment(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateDepartment(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}
