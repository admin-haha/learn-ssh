package com.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.google.gson.JsonObject;
import com.system.po.Useroles;
import com.system.po.Users;
import com.system.repository.CommonRepository;
import com.system.repository.UsersRepository;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CommonRepository commonRepository;
	
	private ModelMap checkUserLogin(HttpServletResponse response,String account,String password,ModelMap context) {
		Users vo = usersRepository.queryByAccountAndPassword(account, password);
		
		
		return context;
	}
	
	/**
	 * 获取所有学院数据
	 * @return
	 */
	public String queryAllUsers() {
		List<String> datas = null;
		return GsonUtils.list2JsonArray(datas).toString();
	}
	public void update(Users users) {
		usersRepository.update(users);
	}
	public void save(Users users) {
		usersRepository.save(users);
	}
	public void delete(Users users) {
		usersRepository.delete(users);
	}
	public Users queryById(String id) {
		return usersRepository.queryById(id);
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
		if(StringUtils.isNotBlank(paramsVo.getRoleIds())) {
			sql = sql+"and r.role_id in ("+paramsVo.getRoleIds()+") ";
		}
		int count = commonRepository.count(sql);
		result.addProperty("total", count);
		sql = sql +"limit "+paramsVo.getOffset()+","+paramsVo.getRows();
		result.add("rows", GsonUtils.list2JsonArray(commonRepository.queryBySql(sql)));
		return result.toString();
	}
	
}
