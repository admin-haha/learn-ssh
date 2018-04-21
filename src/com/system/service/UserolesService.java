package com.system.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.system.po.Useroles;
import com.system.repository.CommonRepository;
import com.system.repository.UserolesRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class UserolesService {

	@Autowired
	private UserolesRepository userolesRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	public void update(Useroles useroles) {
		userolesRepository.update(useroles);
	}
	public void save(Useroles useroles) {
		userolesRepository.save(useroles);
	}
	public void delete(Useroles useroles) {
		userolesRepository.delete(useroles);
	}
	
	public void deleteByRoleId(String roleId) {
		userolesRepository.deleteByRoleId(roleId);
	}
	public void deleteByUserId(String userId) {
		userolesRepository.deleteByUserId(userId);
	}
	
	public Useroles queryById(String id) {
		return userolesRepository.queryById(id);
	}
	
	public Useroles queryByUserId(String userId) {
		return userolesRepository.queryByUserId(userId);
	}
	
	public String queryUserolesByParamsVo(ParamsVo paramsVo) {
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
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
}
