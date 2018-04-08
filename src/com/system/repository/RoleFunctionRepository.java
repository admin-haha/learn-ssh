package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.RoleFunction;
import com.system.vo.ParamsVo;

@Repository
public class RoleFunctionRepository extends BaseRepository<RoleFunction> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(RoleFunction vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into rolefunction(func_id,role_id) ");
		sql.append(" values (");
		sql.append("'").append(vo.getFuncId()).append("',");
		sql.append("'").append(vo.getRoleId()).append("')");
		logger.info("【角色权限】保存角色权限关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void update(RoleFunction vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RoleFunction vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from rolefunction where func_id = '").append(vo.getFuncId()).append("' ");
		sql.append(" and role_id = '").append(vo.getRoleId()).append("' ");
		logger.info("【角色权限】删除角色权限关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}
	
	public void deleteByRoleId(String roleId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from rolefunction where role_id = '").append(roleId).append("' ");
		logger.info("【角色权限】删除人员角色关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}
	
	public void deleteByFuncId(String funcId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from rolefunction where func_id = '").append(funcId).append("' ");
		logger.info("【角色权限】删除角色权限关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
