package com.system.service;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.system.po.RoleFunction;
import com.system.repository.CommonRepository;
import com.system.repository.FunctionRepository;
import com.system.repository.RoleFunctionRepository;
import com.system.utils.GsonUtils;

@Service
public class FunctionService {

	@Autowired
	private FunctionRepository functionRepository;
	@Autowired
	private RoleFunctionRepository roleFunctionRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	public String queryFunctionWithRole(String roleId) {
		List<String> datas = functionRepository.queryRootFunctionWithRole(roleId);
		JsonArray arr = null;
		if(datas!=null&&datas.size()>0) {
			arr = GsonUtils.list2JsonArray(datas);
			for(Iterator it = arr.iterator();it.hasNext();) {
				JsonObject obj = (JsonObject) it.next();
				obj.add("children", GsonUtils.list2JsonArray(functionRepository.querySubFunctionWithRole(StringUtils.remove(obj.get("id").getAsString(), "\""), roleId)));
			}
		}
		return arr.toString();
	}
	
	public String queryRootFunction(String roleId) {
		JsonObject result = new JsonObject();
		List<String> datas = functionRepository.queryRootFunction(roleId);
		if(datas!=null) {
			result.addProperty("total", datas.size());
		}
		result.add("rows", GsonUtils.list2JsonArray(datas));
		return result.toString();
	}
	
	public String querySubFunction(String parentId,String roleId) {
		List<String> datas = functionRepository.querySubFunction(parentId,roleId);
		
		return GsonUtils.list2JsonArray(datas).toString();
	}
	
	public void saveAssign(List<RoleFunction> roleFunctions) {
		if(roleFunctions!=null&&roleFunctions.size()>0) {
			String roleId = roleFunctions.get(0).getRoleId();
			if(StringUtils.isNotBlank(roleId)) {
				//删除原关系
				roleFunctionRepository.deleteByRoleId(roleId);
				String[] sqlArr = new String[]{};
				//保存新关系
				for(RoleFunction vo:roleFunctions) {
					if(StringUtils.isNotBlank(vo.getFuncId())) {
						sqlArr = ArrayUtils.add(sqlArr, roleFunctionRepository.generalSaveSql(vo));
					}
				}
				if(sqlArr.length>0) {
					commonRepository.batchExecute(sqlArr);
				}
			}
		}
	}
}
