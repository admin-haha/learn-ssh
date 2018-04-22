package com.system.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	
	public List<String> queryRootFunctionWithRole(String roleId) {
		String sql = "select "
				+ "json_object('id',f.func_id,'name',f.name,'checked',(case when rf.role_id is null then '' else 'true' end),'funcKey',f.func_key,'funcUrl',f.func_url,'funcOrder',f.func_order,'createTime',DATE_FORMAT(f.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(f.update_time,'%Y-%m-%d')) "
				+ " from function f left join rolefunction rf on rf.func_id = f.func_id and rf.role_id = '"+roleId+"'  where parent_id = '-1' order by func_order asc";
		logger.info("【权限】获取父权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
		
	}

	public List<String> querySubFunctionWithRole(String parentId,String roleId) {
		String sql = "select json_object('id',f.func_id,'name',f.name,'checked',(case when rf.role_id is null then '' else 'true' end),'funcKey',f.func_key,'funcUrl',f.func_url,'funcOrder',f.func_order,'createTime',DATE_FORMAT(f.create_time,'%Y-%m-%d'),'updateTime',DATE_FORMAT(f.update_time,'%Y-%m-%d')) from function f left join rolefunction rf on rf.func_id = f.func_id and rf.role_id = '"+roleId+"' where f.parent_id = '"+parentId+"' order by func_order asc";
		logger.info("【权限】获取子权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<String> queryRootFunction(String roleId) {
		String sql = "select "
				+ "json_object('functionId',r.func_id,'parentId',r.parent_id,'funcname',r.name,'detailinfo',r.func_url,'funcorder',r.func_order)"
				+ " from function r where r.parent_id = '-1'";
				if(StringUtils.isNotBlank(roleId)) {
					sql += " and exists (select 1 from rolefunction rf join role f on f.role_id = rf.role_id where rf.func_id = r.func_id and  f.role_id = '"+roleId+"') ";
				}
				sql += " order by r.func_order asc";
		logger.info("【权限】获取父权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public List<String> querySubFunction(String parentId,String roleId) {
		String sql = "select json_object('id',f.func_id,'iconCls','null','parentId',f.parent_id,'text',concat('<a href=\\\"javascript:addTab(\\\'',f.name,'\\\',\\\'',f.func_url,'\\\',\\\'',f.func_id,'\\\');\\\">',f.name,'</a>')) from function f ";
				if(StringUtils.isNotBlank(roleId)) {
					sql += " and exists (select 1 from rolefunction rf join role r on r.role_id = rf.role_id where rf.func_id = f.func_id and  r.role_id = '"+roleId+"') ";
				}
				sql += "where f.parent_id = '"+parentId+"' order by f.func_order asc";
		logger.info("【权限】获取子权限的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
}
