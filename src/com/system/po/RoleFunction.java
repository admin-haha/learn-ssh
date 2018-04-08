package com.system.po;

/**
 * 角色权限关系
 * 
 *
 */
public class RoleFunction extends BasePo {

	private static final long serialVersionUID = 1L;

	private String roleId; //角色ID
	
	private String funcId; //权限ID

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	
}
