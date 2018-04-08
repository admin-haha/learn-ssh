package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/function")
public class FunctionController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllFunctions(HttpServletRequest request,HttpServletResponse response) {
		
		return "/function/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/function/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateFunction(HttpServletRequest request,HttpServletResponse response) {
	
		return "/function/update";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}

}
