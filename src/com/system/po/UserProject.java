package com.system.po;

/**
 * 学生与毕设题目关系
 * 
 *
 */
public class UserProject extends BasePo {

	private static final long serialVersionUID = 1L;

	private String userId; //学生ID
	
	private String projectId; //毕设题目ID
	
	private String score; //评分
	
	private String memo; //备注
	
	private String checkBy; //审批人ID
	
	private String checkDate; //审批日期

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCheckBy() {
		return checkBy;
	}

	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	
}
