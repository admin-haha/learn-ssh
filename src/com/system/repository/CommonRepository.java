package com.system.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository {

	private Logger logger = LoggerFactory.getLogger(CommonRepository.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public int count(String sql) {
		String countSql = "select count(1) from ("+sql+") aa";
		logger.info("【计数】计算行数的为："+countSql);
		return jdbcTemplate.queryForInt(countSql);
	}
}
