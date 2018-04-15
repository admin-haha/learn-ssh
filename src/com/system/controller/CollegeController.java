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

import com.system.po.College;
import com.system.service.CollegeService;
import com.system.utils.WebHelper;
import com.system.vo.ParamsVo;

@Controller
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toAueryPage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/college/list";
	}
	
	@RequestMapping(value="/manage",method=RequestMethod.GET)
	public String toManagePage(HttpServletRequest request,HttpServletResponse response) {
		
		return "/college/manage";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void queryAllColleges(HttpServletRequest request,HttpServletResponse response,String name,int rows,int page) throws Exception {
		ParamsVo paramVo = new ParamsVo();
		paramVo.setName(name);
		paramVo.setPage(page);
		paramVo.setRows(rows);
		WebHelper.sendData(response, collegeService.queryCollegeByParamsVo(paramVo));
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toSaveCollege(HttpServletRequest request,HttpServletResponse response) {
		return "/college/add";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String toUpdateCollege(HttpServletRequest request,HttpServletResponse response,String id,ModelMap content) {
		content.addAttribute("college", collegeService.queryById(id));
		return "/college/update";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteCollege(HttpServletRequest request,HttpServletResponse response,@RequestBody College college) {
		collegeService.delete(college);
		return "{'flag':'0','msg':'删除成功'}";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String saveCollege(HttpServletRequest request,HttpServletResponse response,@RequestBody College college) {
		collegeService.save(college);
		return "{'flag':'0','msg':'新增成功'}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String updateCollege(HttpServletRequest request,HttpServletResponse response,@RequestBody College college) {
		collegeService.update(college);
		return "{'flag':'0','msg':'修改成功'}";
	}
	
	@RequestMapping(value="/queryAllCollege",method=RequestMethod.GET)
	public void queryAllCollege(HttpServletRequest request,HttpServletResponse response) {
		WebHelper.sendData(response, collegeService.queryAllCollege());
	}
}
