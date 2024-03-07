package com.employeePortal.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.employeePortal.entity.ProfileInformation;


public interface ProfileService {
	
	
	Map<String, Object> GetByEmployeeId(Long employeeID);
	Map<String, Object> getByEmployeeName(String employeeName);
	Map<String, Object> UpdateMobileNumber(Long employeeId, Long mobileNumber);	  
	Map<String, Object> getEmployeeDetailsById(Long employeeId);
	Map<String, Object> findAllEmployees();
	Map<String, Object> updateAboutByEmployeeId(Long employeeId, String about);	
	Map<String, Object> uploadImage(Long employeeId, MultipartFile image) throws IOException;
	Map<String, Object> getEmailIdByEmployeeID(Long employeeID);
	Map<String, Object> UpdateThemeCOlor(Long employeeId, String themeColor);
	Map<String, Object> getAllEmployeesNames();
	Map<String, Object> InsertEMployee(ProfileInformation information);
	Map<String, Object> getEmployeeDataByIdAndPassword(Long employeeId, String employeeName);
	Map<String, Object> findAllemployeesById(Long employeeId);
	Map<String, Object> findAllemployeesByName(String employeeName);
	Map<String, Object> UpdateProfileById(ProfileInformation information);
	Map<String, Object> UpdateReportingManagerNameByEmpId(Long employeeId, String reportingManager);
	Map<String, Object> UpdateShiftTimingsByEmpId(Long employeeId, String shiftTimes);




}
