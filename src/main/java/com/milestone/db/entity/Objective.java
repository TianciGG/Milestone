package com.milestone.db.entity;

public class Objective {
	private String objectiveId;

	private String objectiveUid;

	private String objectiveEmphasize;

	private String objectiveTitle;

	private String objectiveRemark;

	private String objectiveBegindatetime;

	private String objectiveEnddatetime;

	private String objectiveFinishdatetime;

	private String objectiveStatus;

	private String days;

	private String hours;

	private String minutes;

	public String getObjectiveId() {
		return objectiveId;
	}

	public void setObjectiveId(String objectiveId) {
		this.objectiveId = objectiveId;
	}

	public String getObjectiveUid() {
		return objectiveUid;
	}

	public void setObjectiveUid(String objectiveUid) {
		this.objectiveUid = objectiveUid;
	}

	public String getObjectiveEmphasize() {
		return objectiveEmphasize;
	}

	public void setObjectiveEmphasize(String objectiveEmphasize) {
		this.objectiveEmphasize = objectiveEmphasize == null ? null
				: objectiveEmphasize.trim();
	}

	public String getObjectiveTitle() {
		return objectiveTitle;
	}

	public void setObjectiveTitle(String objectiveTitle) {
		this.objectiveTitle = objectiveTitle == null ? null : objectiveTitle
				.trim();
	}

	public String getObjectiveRemark() {
		return objectiveRemark;
	}

	public void setObjectiveRemark(String objectiveRemark) {
		this.objectiveRemark = objectiveRemark == null ? null : objectiveRemark
				.trim();
	}

	public String getObjectiveBegindatetime() {
		return objectiveBegindatetime;
	}

	public void setObjectiveBegindatetime(String objectiveBegindatetime) {
		this.objectiveBegindatetime = objectiveBegindatetime;
	}

	public String getObjectiveEnddatetime() {
		return objectiveEnddatetime;
	}

	public void setObjectiveEnddatetime(String objectiveEnddatetime) {
		this.objectiveEnddatetime = objectiveEnddatetime;
	}

	public String getObjectiveFinishdatetime() {
		return objectiveFinishdatetime;
	}

	public void setObjectiveFinishdatetime(String objectiveFinishdatetime) {
		this.objectiveFinishdatetime = objectiveFinishdatetime;
	}

	public String getObjectiveStatus() {
		return objectiveStatus;
	}

	public void setObjectiveStatus(String objectiveStatus) {
		this.objectiveStatus = objectiveStatus == null ? null : objectiveStatus
				.trim();
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

}