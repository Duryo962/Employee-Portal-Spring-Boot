package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.LeaveDetailsInformation;


public interface LeavesService {
	Map<String, Object> insertLeave(LeaveDetailsInformation leaveDetails);
	Map<String, Object> fetchLeavsById(Long employeeId);
	Map<String, Object> getLeavesByReportingManagerAndStatus(String reportingManager, String leaveStatus);
	Map<String, Object> updateLeaveStatusById(Long uniqueNumber, String leaveStatus);

}
