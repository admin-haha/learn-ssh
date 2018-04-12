package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.Roles;
import com.system.repository.RolesRepository;

@Controller
@RequestMapping("/role")
public class RolesController {

	Logger logger = LoggerFactory.getLogger(RolesController.class);
	@Autowired
	RolesRepository rolesRepository;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllRoles(HttpServletRequest request,HttpServletResponse response) {
		
		return "/role/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveRole(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/role/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/role/update";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.GET)
	public String toAssignRole(HttpServletRequest request,HttpServletResponse response) {
	
		return "/role/assign-role";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveRole(HttpServletRequest request,HttpServletResponse response,String name,String memo,@RequestBody Roles vo) {
		Roles role = new Roles();
		role.setName(name);
		role.setMemo(memo);
		rolesRepository.save(vo);
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.POST)
	public void assignRole(HttpServletRequest request,HttpServletResponse response) {
	
		
	}
}
