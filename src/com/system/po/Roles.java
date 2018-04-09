package com.system.po;

/**
 * 角色
 * 
 *
 */
public class Roles extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name; //角色名称

	private String memo; //角色描述
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
