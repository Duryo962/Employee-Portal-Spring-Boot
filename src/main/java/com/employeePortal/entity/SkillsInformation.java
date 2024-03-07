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
@Table(name = "Skills_Information")
public class SkillsInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id",nullable = false)
	private Long id;
	@Column(name = "Employee_ID",nullable = false)
	private Long employeeId;
	@Column(name = "Employee_Name",nullable = false)
	private String employeeName;
	@Column(name = "Working",nullable = false)
	private String working;
	@Column(name = "Company_Name")
	private String companyName;
	@Column(name = "Skill",nullable = false)
	private String skill;
	@Column (name = "Start_Date",nullable = false)
	private Date startDate;
	@Column(name = "End Date",nullable = false)
	private Date endDate;
	@Column(name = "Skills_Period_Days",nullable = true)
	private Integer skillsPeriodDays;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getWorking() {
		return working;
	}
	public void setWorking(String working) {
		this.working = working;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
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
	public Integer getSkillsPeriodDays() {
		return skillsPeriodDays;
	}
	public void setSkillsPeriodDays(Integer skillsPeriodDays) {
		this.skillsPeriodDays = skillsPeriodDays;
	}
	
	

}
