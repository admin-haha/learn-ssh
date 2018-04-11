package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Department;
import com.system.vo.ParamsVo;

@Repository
public class DepartmentRepository extends BaseRepository<Department> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Department vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into department(id,name)");
		sql.append(" values (");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getName()).append("')");
		logger.info("【科系】保存科系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void update(Department vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update department");
		sql.append(" set ");
		sql.append(" name ='").append(vo.getName()).append("',");
		sql.append(" update_time = current_timestamp ");
		sql.append(" where id = '").append(vo.getId()).append("' ");
		logger.info("【科系】更新科系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void delete(Department vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from department where id = '").append(vo.getId()).append("' ");
		logger.info("【科系】删除科系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
