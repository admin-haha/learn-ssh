package com.system.po;

/**
 * 权限
 * 
 *
 */
public class Function extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name; //权限名称
	
	private String funcUrl; //权限url
	
	private String funcOrder; //权限顺序

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getFuncOrder() {
		return funcOrder;
	}

	public void setFuncOrder(String funcOrder) {
		this.funcOrder = funcOrder;
	}
}
