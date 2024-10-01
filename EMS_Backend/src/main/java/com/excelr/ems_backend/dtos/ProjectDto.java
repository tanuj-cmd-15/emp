package com.excelr.ems_backend.dtos;

import java.util.Date;

public class ProjectDto {
	
	private int projectCode;

	private Date startDate;

	private Date endDate;

	private String clientName;

	private String projectName;

	private String reportingManagerEmployeeCode;

	private String reportingManagerEmployeeMail;


	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReportingManagerEmployeeCode() {
		return reportingManagerEmployeeCode;
	}

	public void setReportingManagerEmployeeCode(String reportingManagerEmployeeCode) {
		this.reportingManagerEmployeeCode = reportingManagerEmployeeCode;
	}

	public String getReportingManagerEmployeeMail() {
		return reportingManagerEmployeeMail;
	}

	public void setReportingManagerEmployeeMail(String reportingManagerEmployeeMail) {
		this.reportingManagerEmployeeMail = reportingManagerEmployeeMail;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectCode=" + projectCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", clientName=" + clientName + ", projectName=" + projectName
				+ ", reportingManagerEmployeeCode=" + reportingManagerEmployeeCode + ", reportingManagerEmployeeMail="
				+ reportingManagerEmployeeMail+"]";
	}

	public ProjectDto() {
		
	}
	
}
