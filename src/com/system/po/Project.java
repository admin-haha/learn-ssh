package com.system.po;

/**
 * 毕业设计题目
 * 
 *
 */
public class Project extends BasePo {

	private static final long serialVersionUID = 1L;

	private String title; //题目名称
	
	private String detail; //详细描述
	
	private String memo; //备注
	
	private String studentCount; //学生个数
	
	private String belongTo; //所属教师ID
	
	private String collegeId; //所属学院
	
	private String departmentId; //所属专业
	
	private Integer status; //状态  默认 通过0  ；不通过1
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(String studentCount) {
		this.studentCount = studentCount;
	}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
