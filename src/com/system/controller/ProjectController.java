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

import com.system.po.Project;
import com.system.po.UserProject;
import com.system.service.ProjectService;
import com.system.service.UserProjectService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserProjectService userProjectService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllProjects(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/manage";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllProjects(HttpServletRequest request,HttpServletResponse response,String name,String department,String college,int rows,int page) {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		paramVo.setCollegeIds(college);
		paramVo.setDepartmentIds(department);
		WebHelper.sendData(response, null);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveProject(HttpServletRequest request,HttpServletResponse response) {
		return "/project/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateProject(HttpServletRequest request,HttpServletResponse response,String id,ModelMap content) {
		content.addAttribute("project", projectService.queryById(id));
		return "/project/update";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveProject(HttpServletRequest request,HttpServletResponse response,@RequestBody Project project) {
		projectService.save(project);
		return "{'flag':'0','msg':'新增成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateProject(HttpServletRequest request,HttpServletResponse response,@RequestBody Project project) {
		projectService.update(project);
		return "{'flag':'0','msg':'修改成功'}";
	}
	
	@RequestMapping(value="/chooseProject",method=RequestMethod.GET)
	public String toChooseProject(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/choose-project";
	}
	
	@RequestMapping(value="/chooseProject",method=RequestMethod.POST)
	@ResponseBody
	public String chooseProject(HttpServletRequest request,HttpServletResponse response,@RequestBody UserProject userProject) {
		userProjectService.save(userProject);
		return "{'flag':'0','msg':'保存成功'}";
	}
}
