package com.system.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.system.po.BasePo;
import com.system.vo.ParamsVo;

/**
 * 数据库操作 基础类 
 * 
 * 数据操作全部使用 spring提供的jdbcTemplate实现
 *
 */
public abstract class BaseRepository<T> {

	protected Logger logger = LoggerFactory.getLogger(BaseRepository.class);
	
	public abstract void save(T vo) ;
	
	public abstract void update(T vo);
	
	public abstract void delete(T vo);
	
	public abstract List<BasePo> queryForList(ParamsVo vo);
	
	
}
