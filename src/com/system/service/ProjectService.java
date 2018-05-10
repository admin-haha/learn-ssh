package com.system.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.system.po.Project;
import com.system.repository.CommonRepository;
import com.system.repository.ProjectRepository;
import com.system.repository.UserProjectRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private UserProjectRepository userProjectRepository;
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllProjects() {
		List<String> datas = null;
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(Project project) {
		projectRepository.update(project);
	}
	public void save(Project project) {
		projectRepository.save(project);
	}
	public void delete(Project project) {
		//删除选题关系
		userProjectRepository.deleteByProjectId(project.getId());
		//删除
		projectRepository.delete(project);
	}
	public Project queryById(String id) {
		return projectRepository.queryById(id);
	}
	
	public void updateStatus(String projectId,Integer status) {
		projectRepository.updateStatus(projectId, status);
	}
	
	public String queryProjectsByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',p.id,'text',p.title,'checkStatus',p.status,'chooseCount',(select count(1) from userproject up where up.project_id = p.id),'belongTo',p.belong_to,'teacher',u.name,'detail',p.detail,'memo',p.memo,'studentCount',p.student_count,'canChoose',(case when (select count(1) from userproject up where up.project_id = p.id)=p.student_count then '1' else '0' end),'college',c.name,'department',d.name,'createTime',DATE_FORMAT(u.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(u.update_time,'%Y-%m-%d')) from project p "
				+ " left join college c on c.id = p.college_id left join department d on p.department_id = d.id and d.college_id = c.id "
				+ " left join users u on u.user_id = p.belong_to "
				+ " where 1=1 "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+" and p.title like '%"+paramsVo.getName()+"%' ";
		}
		if(StringUtils.isNotBlank(paramsVo.getCollegeIds())) {
			sql = sql+"and c.id in ("+paramsVo.getCollegeIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getDepartmentIds())) {
			sql = sql+"and d.id in ("+paramsVo.getDepartmentIds()+") ";
		}
		if(StringUtils.isNotBlank(paramsVo.getTeacherIds())) {
			sql = sql+"and u.user_id in ("+paramsVo.getTeacherIds()+") ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
}
