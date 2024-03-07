package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.ReportingManagerInformation;

public interface ReportingManagerService {
	
	Map<String, Object> findReportingManagerById(Long employeeId);
	Map<String, Object>UpdateManagerDetailsById( ReportingManagerInformation managerDetails);
	Map<String, Object> createReportingManager(ReportingManagerInformation managerInformation);
	Map<String, Object> deleteReoortingManager(long id);
	Map<String, Object> findAllbyEmpId(Long employeeId);
	Map<String, Object> findAllbyEmpName(String employeeName);
	Map<String, Object> findAllbyEmpNameAndId(Long employeeId, String employeeName);


}
