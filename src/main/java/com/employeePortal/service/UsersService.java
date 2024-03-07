package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.UsersInformation;

public interface UsersService {
	
	Map<String, Object> fetchById(String userId);
	Map<String, Object> getAllUsersDetails();
	Map<String, Object> insertUser(UsersInformation details);
	Map<String, Object> updateUser(String userId, UsersInformation details);
	Map<String, Object> deleteStudent(String userId);
	Map<String, Object> updatePasswordByUserId(String userId, String newPassword);

}
