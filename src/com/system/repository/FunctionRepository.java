package com.system.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.po.BasePo;
import com.system.po.Function;
import com.system.utils.StringKit;
import com.system.vo.ParamsVo;

@Repository
public class FunctionRepository extends BaseRepository<Function> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Function vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into function(id,name,func_url,func_order)");
		sql.append(" values (");
		sql.append("'").append(vo.getId()).append("', ");
		sql.append("'").append(vo.getName()).append("', ");
		sql.append("'").append(vo.getFuncUrl()).append("', ");
		sql.append(StringKit.toInt(vo.getFuncOrder())).append(") ");
		logger.info("【权限】保存权限的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
		
	}

	@Override
	public void update(Function vo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update function(id,name,func_url,func_order)");
		sql.append(" set (");
		sql.append(" name = '").append(vo.getName()).append("', ");
		sql.append(" func_url = '").append(vo.getFuncUrl()).append("', ");
		sql.append(" func_order = ").append(StringKit.toInt(vo.getFuncOrder())).append(", ");
		sql.append(" update_time = current_timestamp ");
		sql.append(" where id = '").append(vo.getId()).append("' ");
		logger.info("【权限】更新权限的sql为："+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public void delete(Function vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from function where id = '").append(vo.getId()).append("' ");
		logger.info("【权限】删除权限的sql为:"+sql.toString());
		jdbcTemplate.execute(sql.toString());
	}

	@Override
	public List<BasePo> queryForList(ParamsVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> queryRootFunction() {
		String sql = "select "
				+ "json_object('functionId',func_id,'parentId',parent_id,'funcname',name,'detailinfo',func_url,'funcorder',func_order)"
				+ " from function where parent_id = '-1' order by func_order asc";
		logger.info("【权限】获取父权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public List<String> querySubFunction(String parentId) {
		String sql = "select json_object('id',func_id,'iconCls','null','parentId',parent_id,'text',concat('<a href=\\\"javascript:addTab(\\\'',name,'\\\',\\\'',func_url,'\\\',\\\'',func_id,'\\\');\\\">',name,'</a>')) from function where parent_id = '"+parentId+"' order by func_order asc";
		logger.info("【权限】获取父权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
}
