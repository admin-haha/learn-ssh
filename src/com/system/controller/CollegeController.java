package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/college")
public class CollegeController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllColleges(HttpServletRequest request,HttpServletResponse response) {
		
		return "/college/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveCollege(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/college/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateCollege(HttpServletRequest request,HttpServletResponse response) {
	
		return "/college/update";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveCollege(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateCollege(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}