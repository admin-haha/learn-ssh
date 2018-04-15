package com.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.system.repository.FunctionRepository;
import com.system.utils.GsonUtils;

@Service
public class FunctionService {

	@Autowired
	private FunctionRepository functionRepository;
	
	public String queryRootFunction() {
		JsonObject result = new JsonObject();
		List<String> datas = functionRepository.queryRootFunction();
		if(datas!=null) {
			result.addProperty("total", datas.size());
		}
		result.add("rows", GsonUtils.list2JsonArray(datas));
		return result.toString();
	}
	
	public String querySubFunction(String parentId) {
		List<String> datas = functionRepository.querySubFunction(parentId);
		
		return GsonUtils.list2JsonArray(datas).toString();
	}
}
