package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.service.UserProjectService;

@Controller
@RequestMapping("/userProject")
public class UserProjectController {

	@Autowired
	private UserProjectService userProjectService;
	
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
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	@ResponseBody
	public String check(HttpServletRequest request,HttpServletResponse response,ModelMap content,String projectId,String userId,Integer status) {
		userProjectService.updateStatus(projectId, userId, status);
		return "{'flag':'0','msg':'保存成功'}";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateUserProject(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
}
