package com.system.po;

/**
 * 科系
 * 
 *
 */
public class Department extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name; //科系名称

	private String collegeId; //学院id
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	
	
}
