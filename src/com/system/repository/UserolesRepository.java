package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Useroles;
import com.system.vo.ParamsVo;

@Repository
public class UserolesRepository extends BaseRepository<Useroles> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Useroles vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into useroles(user_id,role_id) ");
		sql.append(" values (");
		sql.append("'").append(vo.getUserId()).append("',");
		sql.append("'").append(vo.getRoleId()).append("')");
		logger.info("【人员角色】保存人员角色关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void update(Useroles vo) {
		// TODO nothing to do
	}

	@Override
	public void delete(Useroles vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from useroles where user_id = '").append(vo.getUserId()).append("' ");
		sql.append(" and role_id = '").append(vo.getRoleId()).append("' ");
		logger.info("【人员角色】删除人员角色关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	public void deleteByRoleId(String roleId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from useroles where role_id = '").append(roleId).append("' ");
		logger.info("【人员角色】删除人员角色关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}
	
	public void deleteByUserId(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from useroles where user_id = '").append(userId).append("' ");
		logger.info("【人员角色】删除人员角色关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}
	
	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Useroles queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
