package com.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.google.gson.JsonObject;
import com.system.excel.utils.SimpleExcelExportUtil;
import com.system.excel.vo.BaseCollegeAndDepartmentVo;
import com.system.excel.vo.BaseExportVo;
import com.system.excel.vo.UsersTemplateVo;
import com.system.po.Useroles;
import com.system.po.Users;
import com.system.repository.CommonRepository;
import com.system.repository.UsersRepository;
import com.system.utils.GsonUtils;
import com.system.utils.StringKit;
import com.system.vo.ParamsVo;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private SimpleExcelExportUtil simpleExcelExportUtil;
	@Autowired
	private CollegeService collegeService;
	
	private ModelMap checkUserLogin(HttpServletResponse response,String account,String password,ModelMap context) {
		Users vo = usersRepository.queryByAccountAndPassword(account, password);
		
		
		return context;
	}
	
	public Users queryByAccountAndPassword(String account,String password) {
		return usersRepository.queryByAccountAndPassword(account, password);
	}
	
	public boolean checkAccountIsExists(String account) {
		int count = usersRepository.queryByAccount(account);
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllUsers() {
		List<String> datas = null;
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(Users users) {
		usersRepository.update(users);
	}
	public void save(Users users) {
		if(!checkAccountIsExists(users.getAccount())) {
			usersRepository.save(users);
		}
	}
	public void batchSave(List<Users> datas) {
		if(datas!=null&&datas.size()>0) {
			for(Users vo:datas) {
				if(vo!=null) {
					String mobile = StringKit.filter(StringKit.toString(vo.getMobile()).trim());
					if(!checkAccountIsExists(mobile)) { //如果账号存在跳过
						vo.setName(StringKit.filter(StringKit.toString(vo.getMobile()).trim()));
						vo.setGender(StringKit.toInt(StringKit.filter(StringKit.toString(vo.getGender()).trim())));
						vo.setCollegeId(StringKit.filter(StringKit.toString(vo.getCollegeId()).trim()));
						vo.setDepartmentId(StringKit.filter(StringKit.toString(vo.getDepartmentId()).trim()));
						vo.setMobile(mobile);
						vo.setAccount(mobile);
						vo.setPassword(mobile);
						usersRepository.save(vo);
					}
				}
			}
		}
	}
	public void delete(Users users) {
		usersRepository.delete(users);
	}
	public Users queryById(String id) {
		return usersRepository.queryById(id);
	}
	
	public String queryAllTeacher() {
		List<String> datas = usersRepository.queryAllTeacher();
		return GsonUtils.list2JsonArray(datas).toString();
	}
	
	public String queryUsersByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',u.user_id,'name',u.name,'account',u.account,'mobile',u.mobile,'gender',(case when u.gender = 0 then '男' else '女' end),'role',r.name,'college',c.name,'department',d.name,'createTime',DATE_FORMAT(u.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(u.update_time,'%Y-%m-%d')) from users u "
				+ " left join college c on c.id = u.college_id left join department d on u.department_id = d.id and d.college_id = c.id "
				+ " left join useroles ur on ur.user_id = u.user_id "
				+ " left join roles r on r.role_id = ur.role_id "
				+ " left join userproject up on up.user_id = u.user_id "
				+ " left join project p on p.id = up.project_id and p.status = 0 "
				+ " where 1=1 "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+" and u.name like '%"+paramsVo.getName()+"%' ";
		}
		if(StringUtils.isNotBlank(paramsVo.getCollegeIds())) {
			sql = sql+"and c.id in ("+paramsVo.getCollegeIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getDepartmentIds())) {
			sql = sql+"and d.id in ("+paramsVo.getDepartmentIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getRoleIds())) {
			sql = sql+"and r.role_id in ("+paramsVo.getRoleIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getProjectId())) {
			sql = sql+"and p.id = '"+paramsVo.getProjectId()+"' ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
	
	public String queryUsersWithProjectByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',u.user_id,'name',u.name,'score',up.score,'memo',up.memo,'account',u.account,'mobile',u.mobile,'gender',(case when u.gender = 0 then '男' else '女' end),'role',r.name,'college',c.name,'department',d.name,'createTime',DATE_FORMAT(u.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(u.update_time,'%Y-%m-%d')) from users u "
				+ " left join college c on c.id = u.college_id left join department d on u.department_id = d.id and d.college_id = c.id "
				+ " left join useroles ur on ur.user_id = u.user_id "
				+ " left join roles r on r.role_id = ur.role_id "
				+ " join userproject up on up.user_id = u.user_id "
				+ " join project p on p.id = up.project_id "
				+ " where 1=1 "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+" and u.name like '%"+paramsVo.getName()+"%' ";
		}
		if(StringUtils.isNotBlank(paramsVo.getCollegeIds())) {
			sql = sql+"and c.id in ("+paramsVo.getCollegeIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getDepartmentIds())) {
			sql = sql+"and d.id in ("+paramsVo.getDepartmentIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getRoleIds())) {
			sql = sql+"and r.role_id in ("+paramsVo.getRoleIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getProjectId())) {
			sql = sql+"and p.id = '"+paramsVo.getProjectId()+"' ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
	
	public Workbook userTemplate(String fileName) {
		
		BaseExportVo<UsersTemplateVo> vo = new BaseExportVo<UsersTemplateVo>();
		vo.getDatas().add(new UsersTemplateVo());
		BaseExportVo<BaseCollegeAndDepartmentVo> collegeAndDepartment = new BaseExportVo<BaseCollegeAndDepartmentVo>();
		collegeAndDepartment.getDatas().addAll(collegeService.queryAllCollegeAndDepartment());
		Workbook workbook = null;
		try {
			workbook = simpleExcelExportUtil.exportOnlyHeader(workbook, "人员模板", fileName, vo, 0);
			workbook = simpleExcelExportUtil.export(workbook, "学院&科系", fileName, collegeAndDepartment, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return workbook;
	}
	
	public List<String> queryAllNotice(){
		return commonRepository.queryAllNotice();
	}
	
}
