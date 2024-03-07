package com.employeePortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees_Profile_Information")
public class ProfileInformation {
	@Id
	@PrimaryKeyJoinColumn
	@Column(name = "Employee_ID",nullable = false)
	private Long employeeID;
	@Lob
 
	@Column(name = "Image_Url", nullable = true, columnDefinition = "tinyblob")
	private byte[] imageUrl;
	@Column(name = "Employee_Name",nullable = false)
	private String employeeName;
	@Column(name = "Designation",nullable = false)
	private String designation;
	@Column(name = "Email_ID",nullable = false)
	private String emailId;
	@Column(name = "Date_Of_Joining",nullable = false)
	private String dateOfJoining;
	@Column(name = "About",nullable = true)
	private String about;
	@Column(name = "Mobile_Number",nullable = true,length = 10)
	private Long mobileNumber;
	@Column(name = "Reporting_Manager",nullable = true)
	private String reportingManager;
	@Column(name = "Work_From",nullable = true)
	private String workFrom;
	@Column(name = "Shift_Times")
	private String shiftTimes;
	@Column(name = "Theme_Color")
	private String themeColor;
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public byte[] getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getWorkFrom() {
		return workFrom;
	}
	public void setWorkFrom(String workFrom) {
		this.workFrom = workFrom;
	}
	public String getShiftTimes() {
		return shiftTimes;
	}
	public void setShiftTimes(String shiftTimes) {
		this.shiftTimes = shiftTimes;
	}
	public String getThemeColor() {
		return themeColor;
	}
	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}
	
	

}
