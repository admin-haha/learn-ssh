package com.system.service;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.system.po.Roles;
import com.system.repository.CommonRepository;
import com.system.repository.RoleFunctionRepository;
import com.system.repository.RolesRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class RolesService {

	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private RoleFunctionRepository roleFunctionRepository;
	
	/**
	 * 获取所有角色数据
	 * @return
	 */
	public String queryAllRoles() {
		List<String> datas = rolesRepository.queryAllRoles();
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(Roles roles) {
		rolesRepository.update(roles);
	}
	public void save(Roles roles) {
		rolesRepository.save(roles);
	}
	public void delete(Roles roles) {
		//删除分配关系
		roleFunctionRepository.deleteByRoleId(roles.getId());
		//删除角色
		rolesRepository.delete(roles);
	}
	public Roles queryById(String id) {
		return rolesRepository.queryById(id);
	}
	
	public String queryRolesByParamsVo(ParamsVo paramsVo) {
		JsonObject result = new JsonObject();
		String sql = "select json_object('id',r.role_id,'text',r.name,'memo',r.memo,'createTime',DATE_FORMAT(r.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(r.update_time,'%Y-%m-%d'),'assignCount',(select count(1) from useroles ur where ur.role_id = r.role_id)) from roles r where 1=1 "; 
		if(StringUtils.isNotBlank(paramsVo.getName())) {
			sql = sql+"and r.name like '%"+paramsVo.getName()+"%' ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(rolesRepository.queryBySql(sql)));
		return result.toString();
	}
}
