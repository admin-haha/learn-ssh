package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Roles;
import com.system.vo.ParamsVo;

@Repository
public class RolesRepository extends BaseRepository<Roles> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void save(Roles vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into roles(role_id,name,memo)");
		sql.append(" values (");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getName()).append("', ");
		sql.append("'").append(vo.getMemo()).append("') ");
		logger.info("【角色】保存角色的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void update(Roles vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update roles set ");
		sql.append(" id = '").append(vo.getId()).append("',");
		sql.append(" name = '").append(vo.getName()).append("', ");
		sql.append(" update_time =").append("current_timestamp ");
		logger.info("【角色】更新角色的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void delete(Roles vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from roles where id = '").append(vo.getId()).append("' ");
		logger.info("【角色】删除角色的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
