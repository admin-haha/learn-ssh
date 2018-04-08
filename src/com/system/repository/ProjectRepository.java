package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Project;
import com.system.vo.ParamsVo;

@Repository
public class ProjectRepository extends BaseRepository<Project> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Project vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into project(id,title,detail,memo,student_count,belong_to,college_id,department_id) ");
		sql.append(" values(");
		sql.append("'").append(vo.getId()).append("',");
		sql.append("'").append(vo.getTitle()).append("',");
		sql.append("'").append(vo.getDetail()).append("',");
		sql.append("'").append(vo.getMemo()).append("',");
		sql.append(vo.getStudentCount()).append(",");
		sql.append("'").append(vo.getBelongTo()).append("',");
		sql.append("'").append(vo.getCollegeId()).append("',");
		sql.append("'").append(vo.getDepartmentId()).append("') ");

		logger.info("【题目】保存题目的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void update(Project vo) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update project(id,title,detail,memo,student_count,belong_to,college_id,department_id) ");
		sql.append(" set ");
		sql.append(" title = '").append(vo.getTitle()).append("',");
		sql.append(" detail = '").append(vo.getDetail()).append("',");
		sql.append(" memo = '").append(vo.getMemo()).append("',");
		sql.append(" student_count = ").append(vo.getStudentCount()).append(",");
		sql.append(" belong_to = '").append(vo.getBelongTo()).append("',");
		sql.append(" college_id = '").append(vo.getCollegeId()).append("',");
		sql.append(" department_id = '").append(vo.getDepartmentId()).append("' ");
		sql.append(" where id = '").append(vo.getId()).append("' ");
		logger.info("【题目】更新题目的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void delete(Project vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from project where id = '").append(vo.getId()).append("' ");
		logger.info("【题目】删除题目的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
