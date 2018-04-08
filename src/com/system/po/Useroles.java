package com.system.po;

/**
 * 人员角色关系
 * 
 *
 */
public class Useroles extends BasePo {

	private static final long serialVersionUID = 1L;

	private String userId; //人员ID
	
	private String roleId; //角色ID

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
