package com.system.po;

/**
 * 人员
 * 
 *
 */
public class Users extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name; //姓名
	
	private Integer gender; //性别
	
	private String collegeId; //所属学院
	
	private String departmentId; //所属专业
	
	private String account; //登陆账号
	
	private String password; //登陆密码
	
	private String mobile; //联系电话


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
