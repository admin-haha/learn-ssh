package com.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.system.repository.CollegeRepository;
import com.system.utils.GsonUtils;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
	
	public String queryAllCollege() {
		JsonArray array = new JsonArray();
		List<String> datas = collegeRepository.queryAllCollege();
		if(datas!=null&&datas.size()>0) {
			
			for(String item:datas) {
				array.add(GsonUtils.parseString2JsonObject(item));
			}
		}
		return array.toString();
	}
}
