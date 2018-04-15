package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.po.Department;
import com.system.service.DepartmentService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toListPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/department/list";
	}
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/department/manage";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllDepartments(HttpServletRequest request,HttpServletResponse response,String name,String collegeIds,int rows,int page) throws Exception {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setCollegeIds(collegeIds);
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		WebHelper.sendData(response, departmentService.queryDepartmentByParamsVo(paramVo));
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveDepartment(HttpServletRequest request,HttpServletResponse response) {
		return "/department/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateDepartment(HttpServletRequest request,HttpServletResponse response,String id,ModelMap content) {
		content.addAttribute("department", departmentService.queryById(id));
		return "/department/update";
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deletePartment(HttpServletRequest request,HttpServletResponse response,@RequestBody Department department) {
		departmentService.delete(department);
		return "{'flag':'0','msg':'删除成功'}";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveDepartment(HttpServletRequest request,HttpServletResponse response,@RequestBody Department department) {
		departmentService.save(department);
		return "{'flag':'0','msg':'新增成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateDepartment(HttpServletRequest request,HttpServletResponse response,@RequestBody Department department) {
		departmentService.update(department);
		return "{'flag':'0','msg':'修改成功'}";
	}
	@RequestMapping(value="/queryAllDepartment",method=RequestMethod.GET)
	public void queryAllCollege(HttpServletRequest request,HttpServletResponse response,String collegeIds) {
		WebHelper.sendData(response, departmentService.queryAllDepartment(collegeIds));
	}
}
