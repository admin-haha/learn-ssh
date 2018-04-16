package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.po.Users;
import com.system.service.UserService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toQueryPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user/manage";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllUsers(HttpServletRequest request,HttpServletResponse response,String name,String department,String college,int rows,int page) {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		paramVo.setCollegeIds(college);
		paramVo.setDepartmentIds(department);
		WebHelper.sendData(response, userService.queryUsersByParamsVo(paramVo));
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveUser(HttpServletRequest request,HttpServletResponse response) {
		return "/user/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUser(HttpServletRequest request,HttpServletResponse response) {
		return "/user/update";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.GET)
	public String toAssignRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/user/assign-role";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveUser(HttpServletRequest request,HttpServletResponse response,@RequestBody Users users) {
		userService.save(users);
		return "{'flag':'0','msg':'新增成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateUser(HttpServletRequest request,HttpServletResponse response,@RequestBody Users users) {
		userService.update(users);
		return "{'flag':'0','msg':'修改成功'}";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.POST)
	public void assignRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
}
