package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.UserProject;
import com.system.utils.StringKit;
import com.system.vo.ParamsVo;

@Repository
public class UserProjectRepository extends BaseRepository<UserProject> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(UserProject vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into userproject(user_id,project_id)");
		sql.append(" values (");
		sql.append("'").append(vo.getUserId()).append("', ");
		sql.append("'").append(vo.getProjectId()).append("')");
		logger.info("【人员题目】保存人员题目关系的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void update(UserProject vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update userproject set ");
		sql.append(" score = ").append(StringKit.toDouble(vo.getScore())).append(",");
		sql.append(" memo = '").append(StringKit.toString(vo.getMemo())).append("',");
		sql.append(" check_by = '").append(vo.getCheckBy()).append("',");
		sql.append(" check_date = current_timestamp,update_time = current_timestamp ");
		sql.append(" where user_id = '").append(vo.getUserId()).append("'");
		sql.append(" and project_id = '").append(vo.getProjectId()).append("' ");
		logger.info("【人员题目】更新人员题目关系的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void delete(UserProject vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from userproject where user_id = '").append(vo.getUserId()).append("' and project_id = '").append(vo.getProjectId()).append("' ");
		logger.info("【人员题目】删除人员题目关系的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	public void deleteByProjectId(String projectId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from userproject where project_id = '").append(projectId).append("' ");
		logger.info("【人员题目】删除人员题目关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}
	
	public void deleteByUserId(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from userproject where user_id = '").append(userId).append("' ");
		logger.info("【人员题目】删除人员题目关系的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}
	
	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
