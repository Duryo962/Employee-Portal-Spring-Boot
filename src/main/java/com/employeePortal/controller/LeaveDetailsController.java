package com.employeePortal.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortal.entity.LeaveDetailsInformation;
import com.employeePortal.service.LeavesService;


@RestController
@RequestMapping("/api/v1/leaves")
@CrossOrigin("*")
public class LeaveDetailsController {
	
	@Autowired
	private LeavesService service;
	
	@PostMapping("/InsertLeave")
    public ResponseEntity<Map<String, Object>> insertLeaves(@RequestBody LeaveDetailsInformation leaveDetails) {
            leaveDetails.setLeaveAppliedDate(new Date());
            Map<String, Object> map=this.service.insertLeave(leaveDetails);
            return ResponseEntity.ok(map);
    }
	
	@GetMapping("/GetLeaveDetailsByEmpId/{employeeId}")
	public ResponseEntity<Map<String, Object>> fetchLeaveDetaislByEmpId(@PathVariable Long employeeId)
	{
		Map<String, Object> map= this.service.fetchLeavsById(employeeId);
		return ResponseEntity.ok(map);
	}

	@GetMapping("/reportingManager/{reportingManager}/status/{leaveStatus}")
	public ResponseEntity<Map<String, Object>> getLeavesByReportingManagerAndStatus(
	    @PathVariable String reportingManager,
	    @PathVariable String leaveStatus) {
	    Map<String, Object> map= this.service.getLeavesByReportingManagerAndStatus(reportingManager, leaveStatus);
	    return ResponseEntity.ok(map);
	}

	@PutMapping("/uniqueNumber/{uniqueNumber}/status/{leaveStatus}")
	public ResponseEntity<Map<String, Object>> updateLeaveStatusById(@PathVariable Long uniqueNumber, @PathVariable String leaveStatus) {
	    Map<String,Object> map=this.service.updateLeaveStatusById(uniqueNumber, leaveStatus);
	    return ResponseEntity.ok(map);
	}

}
