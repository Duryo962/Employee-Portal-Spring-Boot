package com.employeePortal.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.LeaveDetailsInformation;
import com.employeePortal.exceptionHandling.BadRequestException;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.repository.LeavesInformationRepository;
import com.employeePortal.service.LeavesService;
@Service
public class LeavesServiceimpl implements LeavesService{
	
	@Autowired
	private LeavesInformationRepository repository;
	
	Map<String,Object> map=new HashMap<>();

	@Override
	public Map<String, Object> insertLeave(LeaveDetailsInformation leaveDetails) {
		this.repository.save(leaveDetails);
		map.put("Message", "The leave application has been successfully processed.");
		map.put("Status", HttpStatus.CREATED);
		map.put("data", leaveDetails);
		return map;
	}

	@Override
	public Map<String, Object> fetchLeavsById(Long employeeId) {
		if(employeeId == null || employeeId==0)
		{
			throw new EmployeeNotFoundException("The employee ID was not found. Please try again with a valid employee ID.");
		}
		List<LeaveDetailsInformation> leavesDetails=this.repository.findByEmployeeId(employeeId);
		
		map.put("Message", "The details of leaves have been successfully fetched.");
		map.put("Status", HttpStatus.FOUND);
		map.put("data", leavesDetails);	
		return map;
	}

	@Override
	public Map<String, Object> getLeavesByReportingManagerAndStatus(String reportingManager, String leaveStatus) {
		if(reportingManager ==null || leaveStatus==null)
		{
			throw new BadRequestException("The leave status or reporting manager was not found");
		}
		List<LeaveDetailsInformation> leavesResult=this.repository.findByReportingManagerAndLeaveStatus(reportingManager, leaveStatus);
		
		map.put("Message", "The details of leaves have been successfully fetched.");
		map.put("Status", HttpStatus.FOUND);
		map.put("data", leavesResult);	
		return map;
	}

	@Override
	public Map<String, Object> updateLeaveStatusById(Long uniqueNumber, String leaveStatus) {
		if(uniqueNumber==null || leaveStatus==null)
		{
			throw new BadRequestException("The uniqueNumber or leave status was not found");
		}
		this.repository.updateLeaveStatusById(uniqueNumber, leaveStatus);
		
		map.put("Message", "The leave status has been successfully updated.");
		map.put("Status", HttpStatus.OK);
		map.put("data", "uniqueNumber : "+uniqueNumber+" "+" leaveStatus : "+leaveStatus);
		return map;
	}

}
