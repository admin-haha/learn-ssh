package com.system.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.system.po.Project;
import com.system.po.UserProject;
import com.system.repository.CommonRepository;
import com.system.repository.ProjectRepository;
import com.system.repository.UserProjectRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class UserProjectService {

	@Autowired
	private UserProjectRepository userProjectRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllProjects() {
		List<String> datas = null;
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(UserProject userProject) {
		userProjectRepository.update(userProject);
	}
	public void save(UserProject userProject) {
		userProjectRepository.save(userProject);
	}
	public void delete(UserProject userProject) {
		userProjectRepository.delete(userProject);
	}
	public UserProject queryById(String id) {
		return userProjectRepository.queryById(id);
	}
	
	public String queryUsersByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',u.user_id,'name',u.name,'account',u.account,'mobile',u.mobile,'gender',(case when u.gender = 0 then '男' else '女' end),'role',r.name,'college',c.name,'department',d.name,'createTime',DATE_FORMAT(u.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(u.update_time,'%Y-%m-%d')) from users u "
				+ " left join college c on c.id = u.college_id left join department d on u.department_id = d.id and d.college_id = c.id "
				+ " left join useroles ur on ur.user_id = u.user_id "
				+ " left join roles r on r.role_id = ur.role_id "
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
		
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
}
