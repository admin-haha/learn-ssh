package com.system.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Users;
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
		sql.append("insert into users(id,name,gender,college_id,department_id,account,password,mobile)");
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
		sql.append(" where id = '").append(vo.getId()).append("' ");
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


	@Override
	public Users queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users queryByAccountAndPassword(String account,String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from users where account = '");
		sql.append(account).append("' and password = '");
		sql.append(password).append("' ");
		logger.info("【人员】查询人员数据的sql为:"+sql.toString());
		try {
			return jdbcTemplate.queryForObject(sql.toString(), new RowMapper<Users>() {

				@Override
				public Users mapRow(ResultSet arg0, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
			});
		}catch(Exception e) {
			logger.error("【人员】查询人员信息出错："+e.getMessage(),e);
			return null;
		}
	}
}
