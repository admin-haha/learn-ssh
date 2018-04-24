package com.system.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.system.utils.GsonUtils;

@Repository
public class CommonRepository<T> {

	private Logger logger = LoggerFactory.getLogger(CommonRepository.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public int count(String sql) {
		String countSql = "select count(1) from ("+sql+") aa";
		logger.info("【计数】计算行数的sql为："+countSql);
		return jdbcTemplate.queryForInt(countSql);
	}
	
	public void batchExecute(String[] sqlArr) {
		logger.info("【批量执行】批量执行的sql为："+StringUtils.join(sqlArr,";"));
		jdbcTemplate.batchUpdate(sqlArr);
	}
	
	public List<String> queryBySql(String sql){
		logger.info("【执行sql】sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
	
  public List<T> list2Object(List<String> datas,Class clazz) {
    	List<T> result = new ArrayList<T>();
		if(datas!=null&&datas.size()>0) {
			
			for(String item:datas) {
				result.add((T) GsonUtils.getGson().fromJson(item, clazz));
			}
		}
		return result;
    	
    }
  
  public List<String> queryAllNotice(){
		String sql = "select content from notice order by notice_order ";
		logger.info("【通知】获取通知的sql为:"+sql);
		try {
			return jdbcTemplate.queryForList(sql, String.class);
		}catch(Exception e) {
			return null;
		}
	}
}
