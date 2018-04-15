package com.system.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.system.po.College;
import com.system.po.Department;
import com.system.repository.CollegeRepository;
import com.system.repository.CommonRepository;
import com.system.repository.DepartmentRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllDepartment(String collegeIds) {
		collegeIds = StringUtils.join(StringUtils.split(collegeIds),"','");
		List<String> datas = departmentRepository.queryAllDepartment("'"+collegeIds+"'");
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(Department department) {
		departmentRepository.update(department);
	}
	public void save(Department department) {
		departmentRepository.save(department);
	}
	public void delete(Department department) {
		departmentRepository.delete(department);
	}
	public Department queryById(String id) {
		return departmentRepository.queryById(id);
	}
	
	public String queryDepartmentByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',d.id,'text',d.name,'college',c.name,'createTime',DATE_FORMAT(d.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(d.update_time,'%Y-%m-%d')) from department d left join college c on c.id = d.college_id where 1=1 "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+"and d.name like '%"+paramsVo.getName()+"%' ";
		}
		if(StringUtils.isNotBlank(paramsVo.getCollegeIds())) {
			sql = sql+"and c.id in ("+paramsVo.getCollegeIds()+") ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(departmentRepository.queryBySql(sql)));
		return result.toString();
	}
}
