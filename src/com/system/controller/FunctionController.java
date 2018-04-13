package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.repository.FunctionRepository;
import com.system.service.FunctionService;
import com.system.utils.WebHelper;

@Controller
@RequestMapping("/function")
public class FunctionController {

	private Logger logger = LoggerFactory.getLogger(FunctionController.class);
	@Autowired
	private FunctionService functionService;
	
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
	
	@RequestMapping(value="/assignFunction",method=RequestMethod.GET)
	public String toAssignFunction(HttpServletRequest request,HttpServletResponse response) {
	
		return "/function/assign-function";
	}
	
	@RequestMapping(value="/assignFunction",method=RequestMethod.POST)
	public void assignFunction(HttpServletRequest request,HttpServletResponse response) {
	
		
	}

	@RequestMapping(value="/rootFunction",method=RequestMethod.GET)
	public void queryRootFUnction(HttpServletResponse response) {
		String result = functionService.queryRootFunction();
		WebHelper.sendData(response, result);
	}
	
	@RequestMapping(value="/subFunction",method=RequestMethod.GET)
	public void querySubFUnction(HttpServletResponse response,HttpServletRequest request,String parentId) {
		String result = functionService.querySubFunction(parentId);
		WebHelper.sendData(response, result);
	}
}
