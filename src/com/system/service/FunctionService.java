package com.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
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
		if(datas!=null&&datas.size()>0) {
			result.addProperty("total", datas.size());
			JsonArray array = new JsonArray();
			for(String item:datas) {
				array.add(GsonUtils.parseString2JsonObject(item));
			}
			result.add("rows", array);
		}
		return result.toString();
	}
	
	public String querySubFunction(String parentId) {
		JsonArray array = new JsonArray();
		List<String> datas = functionRepository.querySubFunction(parentId);
		if(datas!=null&&datas.size()>0) {
			
			for(String item:datas) {
				array.add(GsonUtils.parseString2JsonObject(item));
			}
		}
		return array.toString();
	}
}
