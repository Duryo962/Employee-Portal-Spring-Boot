package com.employeePortal.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeePortal.entity.ProfileInformation;
import com.employeePortal.service.ProfileService;

@RestController
@RequestMapping("/api/v1/profile")
@CrossOrigin("*")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@GetMapping("/getProfileById/{employeeID}")
	public ResponseEntity<Map<String, Object>> getByEMployeeId(@PathVariable Long employeeID)
	{
		Map<String, Object> map= this.service.GetByEmployeeId(employeeID);
		return ResponseEntity.ok(map);
	}
	@GetMapping("/GetByEmpName/{employeeName}")
	public ResponseEntity<Map<String, Object>> getByEmployeeName(@PathVariable String employeeName)
	{
		Map<String, Object> map= this.service.getByEmployeeName(employeeName);
		return ResponseEntity.ok(map);
	}
	@GetMapping("/EmployeeDetails")
	public ResponseEntity<Map<String, Object>> getAllEmployeesDetails()
	{
		Map<String, Object> map= this.service.findAllEmployees();
		return ResponseEntity.ok(map);
	}
    @PutMapping("/UpdateMibileNumber/{employeeId}/{MobileNumber}")
    public ResponseEntity<Map<String, Object>> updateMobileNumber(@PathVariable Long employeeId,@PathVariable Long mobileNumber)
    {
    	Map<String, Object> map=this.service.UpdateMobileNumber(employeeId,mobileNumber);
    	return ResponseEntity.ok(map);
    }
    @PutMapping("/updateImage/{employeeId}")
    public ResponseEntity<Map<String, Object>> updateImageUrl(@PathVariable Long employeeId, @RequestParam("image") MultipartFile image) throws IOException {
    	Map<String, Object> map= this.service.uploadImage(employeeId, image);
        return ResponseEntity.ok(map);
    }
    
    @GetMapping("/EmployeeEmail/{employeeId}")
    public ResponseEntity<Map<String, Object>> getEmployeeDetails(@PathVariable Long employeeId) {
    	Map<String, Object> map= this.service.getEmployeeDetailsById(employeeId);
    	return ResponseEntity.ok(map);
    }
    
    @PutMapping("/employeeId/{employeeId}/about/{about}")
    public ResponseEntity<Map<String, Object>> updateAboutByEmployeeId(@PathVariable Long employeeId, @PathVariable String about) {
    	Map<String, Object> map=this.service.updateAboutByEmployeeId(employeeId, about);
    	return ResponseEntity.ok(map);
    }
    
    @GetMapping("/FetchEmailID/{employeeID}")
    public ResponseEntity<Map<String, Object>> getEmailIdByEmployeeID(@PathVariable Long employeeID) {
    	Map<String, Object> map= this.service.getEmailIdByEmployeeID(employeeID);
    	return ResponseEntity.ok(map);
    }
    
    @PutMapping("/UpdateThemeColr/{employeeId}/{themeColor}")
    public ResponseEntity<Map<String, Object>> updateThemeColor(@PathVariable Long employeeId,@PathVariable String themeColor) {
    	Map<String, Object> map= this.service.UpdateThemeCOlor(employeeId, themeColor);
    	return ResponseEntity.ok(map);
    }
    
    @GetMapping("/GetAllUsersNames")
    public ResponseEntity<Map<String, Object>> getAllemployeesNames()
    {
    	Map<String, Object> map= this.service.getAllEmployeesNames();
    	return ResponseEntity.ok(map);
    }
    
    @PostMapping("/InsertEmployee")
    public ResponseEntity<Map<String, Object>> insertEmployee(@RequestBody ProfileInformation information)
    {
    	Map<String, Object> map= this.service.InsertEMployee(information);
    	return ResponseEntity.ok(map);
    }
    
    @GetMapping("/GetUserDataByIdName/{employeeId}/{employeeName}")
    public ResponseEntity<Map<String, Object>> getEmployeeDataByIdName(@PathVariable(name ="employeeId" ) Long employeeId,@PathVariable(name = "employeeName")String employeeName)
    {
    	Map<String, Object> map= this.service.getEmployeeDataByIdAndPassword(employeeId,employeeName);
    	return ResponseEntity.ok(map);
    }
    
    @GetMapping("/FindEmployeesById/{employeeId}")
    public ResponseEntity<Map<String, Object>> findEMployeesById(@PathVariable(name = "employeeId") Long employeeId)
    {
    	Map<String, Object> map= this.service.findAllemployeesById(employeeId);
    	return ResponseEntity.ok(map);
    }
    
    @GetMapping("/FindEmployeesByName/{employeeName}")
    public ResponseEntity<Map<String, Object>> findEMployeesByName(@PathVariable(name = "employeeName") String employeeName)
    {
    	Map<String, Object> map= this.service.findAllemployeesByName(employeeName);
    	return ResponseEntity.ok(map);
    }
    
    @PutMapping("/UpdateEmployeeById")
    public ResponseEntity<Map<String, Object>> updateEmployeeById(@RequestBody ProfileInformation information) {
    	Map<String, Object> map= this.service.UpdateProfileById(information);
    	return ResponseEntity.ok(map);
    }
    
    @PutMapping("/UpdateReportingManagerByEmpId/{employeeId}/{reportingManager}")
    public ResponseEntity<Map<String, Object>> updateReportingManagerById(@PathVariable(name = "employeeId") Long employeeId,@PathVariable(name = "reportingManager") String reportingManager) {
    	Map<String, Object> map= this.service.UpdateReportingManagerNameByEmpId(employeeId,reportingManager);
    	return ResponseEntity.ok(map);
    }
    
    @PutMapping("/UpdateShiftTimesByEmpId/{employeeId}/{shiftTimes}")
    public ResponseEntity<Map<String, Object>> updateShiftTimeById(@PathVariable(name = "employeeId") Long employeeId,@PathVariable(name = "shiftTimes") String shiftTimes) {
    	Map<String, Object> map= this.service.UpdateShiftTimingsByEmpId(employeeId,shiftTimes);
    	return ResponseEntity.ok(map);
    }
    
    
    
  

}
