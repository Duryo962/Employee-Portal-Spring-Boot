package com.employeePortal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortal.entity.ReportingManagerInformation;
import com.employeePortal.service.ReportingManagerService;

@RestController
@RequestMapping("/api/v1/reportingManager")
@CrossOrigin("*")
public class ReportingManagerController {
	
	@Autowired
	private ReportingManagerService service;
	
	@GetMapping("/FindByEmployeeId/{employeeId}")
    public ResponseEntity<Map<String, Object>> findDetailsbyId(@PathVariable Long employeeId) {
        Map<String, Object> map =this.service.findReportingManagerById(employeeId);
        return ResponseEntity.ok(map);
    }

	@PutMapping("/UpdateById")
	public ResponseEntity<Map<String, Object>> UpdateDetailsById(@RequestBody ReportingManagerInformation managerDetails)
	{
		 Map<String, Object> map =this.service.UpdateManagerDetailsById(managerDetails);
		 return ResponseEntity.ok(map);
	}
	
	@PostMapping("/CreateRm")
	public ResponseEntity<Map<String, Object>> createRM(@RequestBody ReportingManagerInformation managerInformation)
	{
		Map<String, Object> map= this.service.createReportingManager(managerInformation);
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/DeleteRm/{id}")
	public ResponseEntity<Map<String, Object>> deleteRM(@PathVariable(name = "id") long id)
	{
		Map<String, Object> map= this.service.deleteReoortingManager(id);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/FindAllByEmployeeId/{employeeId}")
    public ResponseEntity<Map<String, Object>> findAllEMpDetailsByEmpId(@PathVariable(name = "employeeId") Long employeeId) {
        Map<String, Object> map =this.service.findAllbyEmpId(employeeId);
        return ResponseEntity.ok(map);
    }
	
	@GetMapping("/FindAllByEmployeeName/{employeeName}")
    public ResponseEntity<Map<String, Object>> findAllEMpDetailsByEmpName(@PathVariable(name = "employeeName") String employeeName) {
        Map<String, Object> map =this.service.findAllbyEmpName(employeeName);
        return ResponseEntity.ok(map);
    }
	@GetMapping("/FindAllByEmployeeNameAndId/{employeeId}/{employeeName}")
    public ResponseEntity<Map<String, Object>> findAllEMpDetailsByEmpNameAndID(@PathVariable(name = "employeeId") Long employeeId,@PathVariable(name ="employeeName") String employeeName) {
        Map<String, Object> map =this.service.findAllbyEmpNameAndId(employeeId,employeeName);
        return ResponseEntity.ok(map);
    }

}
