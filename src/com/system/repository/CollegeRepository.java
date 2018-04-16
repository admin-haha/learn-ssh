package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.College;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Repository
public class CollegeRepository extends BaseRepository<College> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(College vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into college(id,name)");
		sql.append(" values (");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getName()).append("')");
		logger.info("【学院】保存学院的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void update(College vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update college");
		sql.append(" set ");
		sql.append(" name ='").append(vo.getName()).append("',");
		sql.append(" update_time = current_timestamp ");
		sql.append(" where id = '").append(vo.getId()).append("' ");
		logger.info("【学院】更新学院的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void delete(College vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from college where id = '").append(vo.getId()).append("' ");
		logger.info("【学院】删除学院的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College queryById(String id) {
		String sql = "select json_object('id',id,'name',name) from college where id = '"+id+"' ";
		logger.info("【学院】获取学院的sql为:"+sql); 
		String result = jdbcTemplate.queryForObject(sql, String.class);
		return GsonUtils.getGson().fromJson(result, College.class);
	}

	public List<String> queryAllCollege(){
		String sql = "select json_object('id',id,'text',name) from college ";
		logger.info("【学院】获取学院的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
}
