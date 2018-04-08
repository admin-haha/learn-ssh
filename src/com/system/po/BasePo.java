package com.system.po;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * 基础数据对象
 * 抽取出所有对象的公共字段
 * 
 *
 */
public class BasePo implements Serializable {

	private String id; //主键
	
	private String createTime;  //创建时间
	
	private String updateTime;  //更新时间	
	

	public BasePo() {
		this.id = UUID.randomUUID().toString().replace("-", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
