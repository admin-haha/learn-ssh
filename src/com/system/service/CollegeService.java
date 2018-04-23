package com.system.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.system.excel.vo.BaseCollegeAndDepartmentVo;
import com.system.po.College;
import com.system.repository.CollegeRepository;
import com.system.repository.CommonRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllCollege() {
		List<String> datas = collegeRepository.queryAllCollege();
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(College college) {
		collegeRepository.update(college);
	}
	public void save(College college) {
		collegeRepository.save(college);
	}
	public void delete(College college) {
		collegeRepository.delete(college);
	}
	public College queryById(String id) {
		return collegeRepository.queryById(id);
	}
	
	public String queryCollegeByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',id,'text',name,'createTime',DATE_FORMAT(create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(update_time,'%Y-%m-%d')) from college "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+"where name like '%"+paramsVo.getName()+"%' ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
	
	public List<BaseCollegeAndDepartmentVo> queryAllCollegeAndDepartment(){
		return collegeRepository.queryAllCollegeAndDepartment();
	}
}
