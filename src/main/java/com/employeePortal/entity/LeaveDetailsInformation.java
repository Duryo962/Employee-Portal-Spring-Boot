package com.employeePortal.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Leaves_Information")
public class LeaveDetailsInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Unique_Number")
	private Long uniqueNumber;
	@Column(name = "Employee_ID",nullable = false)
	private Long employeeId;
	@Column(name = "Employee_Name",nullable = false)
	private String employeeName;
	@Column(name = "Reporting_Manager",nullable = false)
	private String reportingManager;
	@Column(name = "Leave_From_Date",nullable = false)
	private Date leaveFromDate;
	@Column(name = "Leave_To_Date")
	private Date leaveToDate;
	@Column(name = "Leave_Status",nullable = false)
	private String leaveStatus;
	@Column(name = "Leave_Applied_Date", nullable = false)
	private java.util.Date leaveAppliedDate;
	@Column(name = "Leave_Type",nullable = false)
	private String leaveType;
	@Column(name = "Leave_Body",nullable = false)
	private String leaveBody;
	@Column(name = "No_Of_Days_Leave")
	private String noOfDaysLeave;
	public Long getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(Long uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public Date getLeaveFromDate() {
		return leaveFromDate;
	}
	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}
	public Date getLeaveToDate() {
		return leaveToDate;
	}
	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public java.util.Date getLeaveAppliedDate() {
		return leaveAppliedDate;
	}
	public void setLeaveAppliedDate(java.util.Date leaveAppliedDate) {
		this.leaveAppliedDate = leaveAppliedDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveBody() {
		return leaveBody;
	}
	public void setLeaveBody(String leaveBody) {
		this.leaveBody = leaveBody;
	}
	public String getNoOfDaysLeave() {
		return noOfDaysLeave;
	}
	public void setNoOfDaysLeave(String noOfDaysLeave) {
		this.noOfDaysLeave = noOfDaysLeave;
	}
	
	
	
}
