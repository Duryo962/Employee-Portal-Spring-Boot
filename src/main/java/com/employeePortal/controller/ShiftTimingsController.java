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

import com.employeePortal.entity.ShiftTimingsInformation;
import com.employeePortal.service.ShiftTimingService;

@RestController
@RequestMapping("/api/v1/shiftTimings")
@CrossOrigin("*")
public class ShiftTimingsController {
	
	@Autowired
	private ShiftTimingService service;
	
	
	@GetMapping("/TimingsById/{employeeId}")
	public ResponseEntity<Map<String, Object>> shiftTimingsById(@PathVariable Long employeeId)
	{
		Map<String, Object> map =this.service.findShiftById(employeeId);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/InsetShiftDetails")
	public ResponseEntity<Map<String, Object>> insertShiftTiming(@RequestBody ShiftTimingsInformation entity)
	{
		Map<String, Object> map =this.service.insertShiftTimingDetails(entity);
		return ResponseEntity.ok(map);
	}
	@PutMapping("/UpdatebyId/{id}")
	public ResponseEntity<Map<String, Object>> updateShiftById(@PathVariable Long id, @RequestBody ShiftTimingsInformation timingsEntity)
	{
		Map<String, Object> map = this.service.UpdateShiftTimings(id,timingsEntity);
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/DeleteShift/{id}")
	public ResponseEntity<Map<String, Object>> deleteShifttime(@PathVariable(name = "id") Long id)
	{                        
		Map<String, Object> map = this.service.DeleteShiftTimings(id);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/FetchingShiftsById/{employeeId}")
	public ResponseEntity<Map<String, Object>> fetchingShiftsById(@PathVariable(name = "employeeId") Long employeeId)
	{
		Map<String, Object> map = this.service.fetchingShiftsById(employeeId);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/FetchingShiftsByName/{employeeName}")
	public ResponseEntity<Map<String, Object>> fetchingShiftsByName(@PathVariable(name = "employeeName") String employeeName)
	{
		Map<String, Object> map = this.service.fetchingShiftsByEmployeeName(employeeName);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/FetchingShiftsByIdAndName/{employeeId}/{employeeName}")
	public ResponseEntity<Map<String, Object>> fetchingShiftsByIdAndName(@PathVariable(name = "employeeId") Long employeeId,@PathVariable(name = "employeeName") String employeeName)
	{
		Map<String, Object> map = this.service.fetchingShiftsByIdAndName(employeeId,employeeName);
		return ResponseEntity.ok(map);
	}

}
