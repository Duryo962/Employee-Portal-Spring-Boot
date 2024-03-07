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
@Table(name = "Holidays_Information")
public class HolidaysInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Unique_number")
	private Long uniqueInteger;
	@Column(name = "HoliDay_Date",nullable = false)
	private Date holiDayDate;
	@Column(name = "Holiday_name",nullable = false)
	private String holidayName;
	@Column(name = "Holiday_Year")
	private Integer holidayYear;
	@Column(name = "Day")
	private String day;
	public Long getUniqueInteger() {
		return uniqueInteger;
	}
	public void setUniqueInteger(Long uniqueInteger) {
		this.uniqueInteger = uniqueInteger;
	}
	public Date getHoliDayDate() {
		return holiDayDate;
	}
	public void setHoliDayDate(Date holiDayDate) {
		this.holiDayDate = holiDayDate;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public Integer getHolidayYear() {
		return holidayYear;
	}
	public void setHolidayYear(Integer holidayYear) {
		this.holidayYear = holidayYear;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	
}
