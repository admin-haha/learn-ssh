package com.system.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.po.Useroles;
import com.system.po.Users;
import com.system.service.FileUploadService;
import com.system.service.UserService;
import com.system.service.UserolesService;
import com.system.utils.FileUtil;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserolesService userolesService;
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toQueryPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/user/manage";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllUsers(HttpServletRequest request,HttpServletResponse response,String name,String department,String college,String role,int rows,int page) {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		paramVo.setCollegeIds(college);
		paramVo.setDepartmentIds(department);
		paramVo.setRoleIds(role);
		WebHelper.sendData(response, userService.queryUsersByParamsVo(paramVo));
	}
	
	@RequestMapping(value="/queryAllUsersWithProject",method=RequestMethod.POST)
	public void queryAllUsersByProject(HttpServletRequest request,HttpServletResponse response,String name,String projectId,int rows,int page) {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		paramVo.setProjectId(projectId);
		WebHelper.sendData(response, userService.queryUsersWithProjectByParamsVo(paramVo));
	}
	
	@RequestMapping(value="/queryAllTeacher",method=RequestMethod.GET)
	public void queryAllTeacher(HttpServletRequest request,HttpServletResponse response) {
		WebHelper.sendData(response, userService.queryAllTeacher());
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveUser(HttpServletRequest request,HttpServletResponse response) {
		return "/user/add";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String toRegisterUser(HttpServletRequest request,HttpServletResponse response) {
		return "/user/register";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateUser(HttpServletRequest request,HttpServletResponse response,String userId,ModelMap content) {
		content.addAttribute("user", userService.queryById(userId));
		return "/user/update";
	}
	
	@RequestMapping(value="/assignRole",method=RequestMethod.GET)
	public String toAssignRole(HttpServletRequest request,HttpServletResponse response,String userId,ModelMap content) {
		content.addAttribute("user", userService.queryById(userId));
		Useroles useroles =  userolesService.queryByUserId(userId);
		content.addAttribute("roleId", useroles!=null?useroles.getRoleId():"");
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
	@ResponseBody
	public String assignRole(HttpServletRequest request,HttpServletResponse response,@RequestBody Useroles useroles) {
		//删除原有关系
		userolesService.deleteByUserId(useroles.getUserId());
		//保存新关系
		userolesService.save(useroles);
		return "{'flag':'0','msg':'分配成功'}";
	}
	
	@RequestMapping(value="/import",method=RequestMethod.GET)
	public String userImport(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		return "/user/user-import";
	}
	
	/**
	 * 人员批量导入
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/import",method=RequestMethod.POST)
	@ResponseBody
	public String userImportDatas(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		try {
			fileUploadService.uploadFile(request, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "{'flag':'0','msg':'导入成功'}";

	}
	
	@RequestMapping(value="/checkAccountIsExists",method=RequestMethod.POST)
	@ResponseBody
	public String checkAccountIsExists(HttpServletRequest request,HttpServletResponse response,String account) throws UnsupportedEncodingException {
		if(userService.checkAccountIsExists(account)) {
			return "{'flag':'1','msg':'该账号已存在'}";
		} else {
			return "{'flag':'0','msg':'账号可用'}";
		}

	}
	
	@RequestMapping(value="/downloadUserTemplate",method=RequestMethod.GET)
	public void downloadUserTemplate(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String userAgent = request.getHeader("USER-AGENT");
		String fileName="";
		if(StringUtils.contains(userAgent, "Firefox")){ //火狐
			fileName =new String(("人员导入模板.xls").getBytes(), "ISO-8859-1");
		}else{
			fileName = "人员导入模板.xls";
		}
		Workbook workbook = userService.userTemplate(fileName);
		if(workbook!=null) {
			FileUtil.exportExcel(response, fileName, workbook);
		}
	}
}
