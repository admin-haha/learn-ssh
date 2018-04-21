package com.system.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * 查询参数封装vo
 * 
 *
 */
public class ParamsVo implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer page;
	
	private Integer rows;
	
	private Integer offset;
	
	private String name;
	
	private String collegeIds;
	
	private String departmentIds;

	private String roleIds;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getOffset() {
		if(rows==null) {
			rows = 20;
		}
		
		if(page==null) {
			page = 1;
		}
		
		offset = (page-1)*rows;
				
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeIds() {
		if(StringUtils.isNotBlank(collegeIds)) {
			return "'"+StringUtils.join(StringUtils.split(collegeIds,","),"','")+"'";
		}
		return collegeIds;
	}

	public void setCollegeIds(String collegeIds) {
		this.collegeIds = collegeIds;
	}

	public String getDepartmentIds() {
		if(StringUtils.isNotBlank(departmentIds)) {
			return "'"+StringUtils.join(StringUtils.split(departmentIds,","),"','")+"'";
		}
		return departmentIds;
	}

	public void setDepartmentIds(String departmentIds) {
		this.departmentIds = departmentIds;
	}

	public String getRoleIds() {
		if(StringUtils.isNotBlank(roleIds)) {
			return "'"+StringUtils.join(StringUtils.split(roleIds,","),"','")+"'";
		}
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	
}
