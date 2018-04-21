package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.po.Roles;
import com.system.service.RolesService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/role")
public class RolesController {

	Logger logger = LoggerFactory.getLogger(RolesController.class);
	@Autowired
	private RolesService rolesService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllRoles(HttpServletRequest request,HttpServletResponse response) {
		
		return "/role/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/role/manage";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveRole(HttpServletRequest request,HttpServletResponse response) {
	
		
		return "/role/add";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllRoles(HttpServletRequest request,HttpServletResponse response,String name,int rows,int page) throws Exception {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		WebHelper.sendData(response, rolesService.queryRolesByParamsVo(paramVo));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateRole(HttpServletRequest request,HttpServletResponse response,String id,ModelMap content) {
		content.addAttribute("role", rolesService.queryById(id));
		return "/role/update";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteCollege(HttpServletRequest request,HttpServletResponse response,@RequestBody Roles roles) {
		rolesService.delete(roles);
		return "{'flag':'0','msg':'删除成功'}";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveRole(HttpServletRequest request,HttpServletResponse response,@RequestBody Roles vo) {
		rolesService.save(vo);
		return "{'flag':'0','msg':'新增成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateRole(HttpServletRequest request,HttpServletResponse response,@RequestBody Roles roles) {
		rolesService.update(roles);
		return "{'flag':'0','msg':'修改成功'}";
	}
	
	@RequestMapping(value="/queryAllRoles",method=RequestMethod.GET)
	public void queryAllCollege(HttpServletRequest request,HttpServletResponse response) {
		WebHelper.sendData(response, rolesService.queryAllRoles());
	}
}
