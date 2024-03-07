package com.employeePortal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortal.entity.UsersInformation;
import com.employeePortal.service.UsersService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@GetMapping("/FetchByUserId/{userId}")
	public ResponseEntity<Map<String, Object>> UserFetchById(@PathVariable String userId)
	{
		Map<String, Object> map= this.service.fetchById(userId);
		return ResponseEntity.ok(map);
	}
	@GetMapping("/GetAllUsersDetails")
	public ResponseEntity<Map<String, Object>> getAllUsersDetails()
	{
		Map<String, Object> map= this.service.getAllUsersDetails();
		return ResponseEntity.ok(map);
	}
	@PostMapping("/InsertUser")
	public ResponseEntity<Map<String, Object>> insertUser(@RequestBody UsersInformation details)
	{
		Map<String, Object> map= this.service.insertUser(details);
		return ResponseEntity.ok(map);
	}
	@PutMapping("/UpdateUser/{userId}")
	public ResponseEntity<Map<String, Object>> updateUserDetails(@RequestBody UsersInformation details,@PathVariable String userId)
	{
		Map<String, Object> map= this.service.updateUser(userId,details);
		return ResponseEntity.ok(map);
	}
	@DeleteMapping("/DeleteUser/{userId}")
	public ResponseEntity<Map<String, Object>> deleteStudentDetails(@PathVariable String userId)
	{
		Map<String, Object> map= this.service.deleteStudent(userId);
		return ResponseEntity.ok(map);
	}
	
	@Transactional
	@PatchMapping("/UpdatePassword/{userId}/{newPassword}")
    public ResponseEntity<Map<String, Object>> updatePassword(
            @PathVariable String userId,
            @PathVariable String newPassword
    ) {
		Map<String, Object> map= service.updatePasswordByUserId(userId, newPassword);
		return ResponseEntity.ok(map);
    }

}
