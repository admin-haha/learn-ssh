package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.constant.Constant;
import com.system.po.Project;
import com.system.po.Roles;
import com.system.po.UserProject;
import com.system.po.Users;
import com.system.service.ProjectService;
import com.system.service.UserProjectService;
import com.system.service.UserService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserProjectService userProjectService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String queryAllProjects(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/manage";
	}
	
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String tocheckPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/check";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllProjects(HttpServletRequest request,HttpServletResponse response,String name,String department,String college,int rows,int page) {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		paramVo.setCollegeIds(college);
		paramVo.setDepartmentIds(department);
		WebHelper.sendData(response, projectService.queryProjectsByParamsVo(paramVo));
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
		Users user = (Users) request.getSession().getAttribute(Constant.SESSION_KEY);
		if(user == null) {
			user = userService.queryById("9850c514b6134a468bebdf4406cea9e1");
		}
		project.setBelongTo(user.getId());
		projectService.save(project);
		return "{'flag':'0','msg':'保存成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateProject(HttpServletRequest request,HttpServletResponse response,@RequestBody Project project) {
		Users user = (Users) request.getSession().getAttribute(Constant.SESSION_KEY);
		if(user == null) {
			user = userService.queryById("9850c514b6134a468bebdf4406cea9e1");
		}
		if(StringUtils.isBlank(project.getBelongTo())) {
			project.setBelongTo(user.getId());
		}
		projectService.update(project);
		return "{'flag':'0','msg':'修改成功'}";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteCollege(HttpServletRequest request,HttpServletResponse response,@RequestBody Project project) {
		projectService.delete(project);
		return "{'flag':'0','msg':'删除成功'}";
	}
	
	@RequestMapping(value="/choose",method=RequestMethod.GET)
	public String toChooseProject(HttpServletRequest request,HttpServletResponse response) {
		
		return "/project/choose-project";
	}
	
	@RequestMapping(value="/choose/result",method=RequestMethod.GET)
	public String chooseResult(HttpServletRequest request,HttpServletResponse response,ModelMap content) {
		
		Users user = (Users) request.getSession().getAttribute(Constant.SESSION_KEY);
		UserProject userProject = null;
		Project project = null;
		Users teacher = null;
		if(user!=null) {
			userProject = userProjectService.queryByUserId(user.getId());
			
			if(userProject!=null) {
				project = projectService.queryById(userProject.getProjectId());
				
				if(project!=null) {
					teacher = userService.queryById(project.getBelongTo());
				}
			}
		}
		content.addAttribute("user", user);
		content.addAttribute("teacher", teacher);
		content.addAttribute("userProject", userProject);
		content.addAttribute("project", project);
		return "/project/user-choose-result";
	}
	
	@RequestMapping(value="/score",method=RequestMethod.GET)
	public String toScore(HttpServletRequest request,HttpServletResponse response,ModelMap content,String userId,String projectId) {
		
		Users user = userService.queryById(userId);
		Project project = projectService.queryById(projectId);
		content.addAttribute("user", user);
		content.addAttribute("project", project);
		return "/project/score";
	}
	
	@RequestMapping(value="/score",method=RequestMethod.POST)
	@ResponseBody
	public String score(HttpServletRequest request,HttpServletResponse response,ModelMap content,@RequestBody UserProject userProject) {
		Users user = (Users) request.getSession().getAttribute(Constant.SESSION_KEY);
		userProject.setCheckBy(user.getId());
		userProjectService.update(userProject);
		return "{'flag':'0','msg':'保存成功'}";
	}
	

	@RequestMapping(value="/check",method=RequestMethod.POST)
	@ResponseBody
	public String check(HttpServletRequest request,HttpServletResponse response,ModelMap content,String projectId,Integer status) {
		projectService.updateStatus(projectId, status);
		return "{'flag':'0','msg':'保存成功'}";
	}
	
	@RequestMapping(value="/toChooseResult",method=RequestMethod.GET)
	public String toChooseProject(HttpServletRequest request,HttpServletResponse response,String id,ModelMap content) {
		Users user = (Users) request.getSession().getAttribute(Constant.SESSION_KEY);
		content.addAttribute("project", projectService.queryById(id));
		content.addAttribute("user", user);
		return "/project/choose-result";
	}
	
	@RequestMapping(value="/choose",method=RequestMethod.POST)
	@ResponseBody
	public String chooseProject(HttpServletRequest request,HttpServletResponse response,@RequestBody UserProject userProject) {
		if(StringUtils.isBlank(userProject.getUserId())) {
			userProject.setUserId("9850c514b6134a468bebdf4406cea9e1");
		}
		userProjectService.deleteByUserId(userProject.getUserId());
		userProjectService.save(userProject);
		return "{'flag':'0','msg':'保存成功'}";
	}
}
