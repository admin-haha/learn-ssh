package com.system.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.College;
import com.system.po.Users;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Repository
public class UsersRepository extends BaseRepository<Users> {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		jdbcTemplate.query("", new RowMapper() {

			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		return null;
	}


	@Override
	public void save(Users vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into users(user_id,name,gender,college_id,department_id,account,password,mobile)");
		sql.append("values( ");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getName()).append("',");
		sql.append(vo.getGender()).append(",");
		sql.append("'").append(vo.getCollegeId()).append("',");
		sql.append("'").append(vo.getDepartmentId()).append("',");
		sql.append("'").append(vo.getAccount()).append("',");
		sql.append("'").append(vo.getPassword()).append("',");
		sql.append("'").append(vo.getMobile()).append("')");
		logger.info("【人员】保存人员的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());		
	}


	@Override
	public void update(Users vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update users set");
		sql.append(" name =").append("'").append(vo.getName()).append("',");
		sql.append(" gender =").append(vo.getGender()).append(",");
		sql.append(" college_id =").append("'").append(vo.getCollegeId()).append("',");
		sql.append(" department_id =").append("'").append(vo.getDepartmentId()).append("',");
		sql.append(" account =").append("'").append(vo.getAccount()).append("',");
		sql.append(" password =").append("'").append(vo.getPassword()).append("',");
		sql.append(" mobile =").append("'").append(vo.getMobile()).append("',");
		sql.append(" update_time =").append("current_timestamp ");
		sql.append(" where user_id = '").append(vo.getId()).append("' ");
		logger.info("【人员】更新人员的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());	
	}


	@Override
	public void delete(Users vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from users where id = '").append(vo.getId()).append("' ");
		logger.info("【人员】删除人员的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}


	public int queryByAccount(String account) {
		String sql = "select count(1) from users where account = '"+account+"' ";
		logger.info("【人员】判断账号是否存在的sql为:"+sql); 
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public Users queryById(String id) {
		String sql = "select json_object('id',user_id,'name',name,'gender',gender,'collegeId',college_id,'departmentId',department_id,'account',account,'password',password,'mobile',mobile,'createTime',DATE_FORMAT(create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(update_time,'%Y-%m-%d')) from users where user_id = '"+id+"' ";
		logger.info("【人员】获取人员的sql为:"+sql); 
		String result = jdbcTemplate.queryForObject(sql, String.class);
		return GsonUtils.getGson().fromJson(result, Users.class);
	}

	public Users queryByAccountAndPassword(String account,String password) {
		String sql = "select json_object('id',user_id,'name',name,'gender',gender,'collegeId',college_id,'departmentId',department_id,'account',account,'password',password,'mobile',mobile,'createTime',DATE_FORMAT(create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(update_time,'%Y-%m-%d')) from users where account = '"+account+"' and password = '"+password+"'";
		logger.info("【人员】获取人员的sql为:"+sql); 
		String result = jdbcTemplate.queryForObject(sql, String.class);
		return GsonUtils.getGson().fromJson(result, Users.class);
	}
}
