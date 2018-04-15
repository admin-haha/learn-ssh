package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.College;
import com.system.po.Department;
import com.system.utils.GsonUtils;
import com.system.vo.ParamsVo;

@Repository
public class DepartmentRepository extends BaseRepository<Department> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Department vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into department(id,name,college_id)");
		sql.append(" values (");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getName()).append("', ");
		sql.append("'").append(vo.getCollegeId()).append("')");
		logger.info("【科系】保存科系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void update(Department vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update department");
		sql.append(" set ");
		sql.append(" name ='").append(vo.getName()).append("',");
		sql.append(" college_id ='").append(vo.getCollegeId()).append("',");
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
		String sql = "select json_object('id',d.id,'name',d.name,'collegeId',c.id) from department d left join college c on d.college_id = c.id  where d.id = '"+id+"' ";
		logger.info("【学院】获取科系的sql为:"+sql); 
		String result = jdbcTemplate.queryForObject(sql, String.class);
		return GsonUtils.getGson().fromJson(result, Department.class);
	}
	public List<String> queryAllDepartment(String collegeIds){
		String sql = "select json_object('id',d.id,'text',d.name,'collegeId',c.id) from department d left join college c on d.college_id = c.id where c.id in ("+collegeIds+")";
		logger.info("【科系】获取科系的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<String> queryBySql(String sql){
		logger.info("【科系】获取科系的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
}
