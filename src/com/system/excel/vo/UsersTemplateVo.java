package com.system.excel.vo;

import java.io.Serializable;

import com.system.excel.annotation.ExportCellStyle;

/**
 * 人员
 * 
 *
 */
public class UsersTemplateVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExportCellStyle(index=0,columnName="姓名",columnWidth=5000)
	private String name; //姓名
	
	@ExportCellStyle(index=1,columnName="性别",columnWidth=5000)
	private String gender; //性别
	
	@ExportCellStyle(index=2,columnName="所属学院",columnWidth=5000)
	private String collegeId; //所属学院
	
	@ExportCellStyle(index=3,columnName="所属专业",columnWidth=5000)
	private String departmentId; //所属专业
	
	@ExportCellStyle(index=4,columnName="联系电话",columnWidth=5000)
	private String mobile; //联系电话


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
