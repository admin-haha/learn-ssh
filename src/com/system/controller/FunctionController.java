package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.repository.FunctionRepository;
import com.system.utils.WebHelper;

@Controller
@RequestMapping("/function")
public class FunctionController {

	@Autowired
	private FunctionRepository functionRepository;
	
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
		/**
		 * {
  "rows": [
    "{\"funcname\": \"人员管理\", \"parentId\": \"-1\", \"funcorder\": 1, \"detailinfo\": \"#\", \"functionId\": \"e1d3d01925694787ae537a5fffd05bdc\"},{\"funcname\": \"角色管理\", \"parentId\": \"-1\", \"funcorder\": 2, \"detailinfo\": \"#\", \"functionId\": \"2f160d292c6148e4ad6d432d3a654838\"},{\"funcname\": \"权限管理\", \"parentId\": \"-1\", \"funcorder\": 3, \"detailinfo\": \"#\", \"functionId\": \"c885fce9558e4a3e9678349d40a51ef2\"},{\"funcname\": \"题目管理\", \"parentId\": \"-1\", \"funcorder\": 4, \"detailinfo\": \"#\", \"functionId\": \"00b2f69f50e540728dfb2de9891d715d\"}"
  ],
  "total": 4
}
		 */
		WebHelper.sendData(response, functionRepository.queryRootFunction());
	}
}
