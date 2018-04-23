package com.system.excel.vo;

import java.io.Serializable;

import com.system.excel.annotation.ExportCellStyle;

/**
 * 学院专业
 * 
 *
 */
public class BaseCollegeAndDepartmentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExportCellStyle(index=0,columnName="学院ID",columnWidth=8000)
	private String collegeId; //学院ID
	
	@ExportCellStyle(index=1,columnName="学院名称",columnWidth=8000)
	private String collegeName; //学院名称
	
	@ExportCellStyle(index=2,columnName="科系ID",columnWidth=8000)
	private String departmentId; //科系Id

	@ExportCellStyle(index=3,columnName="科系名称",columnWidth=8000)
	private String departmentName; //科系名称

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
