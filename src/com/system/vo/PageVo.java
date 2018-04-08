package com.system.vo;

import java.util.List;

import com.system.po.BasePo;

public class PageVo {

	private int total;
	
	private List<BasePo> rows;

	
	public PageVo(int total, List<BasePo> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageVo() {
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<BasePo> getRows() {
		return rows;
	}

	public void setRows(List<BasePo> rows) {
		this.rows = rows;
	}
	
	
}
