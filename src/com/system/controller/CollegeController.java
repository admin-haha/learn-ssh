package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.service.CollegeService;
import com.system.utils.WebHelper;

@Controller
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toAueryPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/college/list";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public void queryAllColleges(HttpServletRequest request,HttpServletResponse response) {
		
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
	
	@RequestMapping(value="/queryAllCollege",method=RequestMethod.GET)
	public void queryAllCollege(HttpServletRequest request,HttpServletResponse response) {
		WebHelper.sendData(response, collegeService.queryAllCollege());
	}
}
