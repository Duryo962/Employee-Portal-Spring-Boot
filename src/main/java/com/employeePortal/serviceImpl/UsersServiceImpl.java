package com.employeePortal.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.UsersInformation;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.repository.UsersRepository;
import com.employeePortal.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository repository;
	
	Map<String,Object> map=new HashMap<>();

	@Override
	public Map<String, Object> fetchById(String userId) {

			UsersInformation information = this.repository.findById(userId)
				    .orElseThrow(() -> new EmployeeNotFoundException("User ID not found"));
			map.put("Message", "User credentials successfully fetched");
			map.put("Status", HttpStatus.OK);
			map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> getAllUsersDetails() {
		List<UsersInformation> information=this.repository.findAll();
		map.put("Message", "All users Credentials has been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> insertUser(UsersInformation details) {
		this.repository.save(details);
		map.put("Message", "User credentials has been successfully uploaded.");
		map.put("Status", HttpStatus.OK);
		map.put("data", details);
		return map;
	}

	@Override
	public Map<String, Object> updateUser(String userId, UsersInformation details) {
		if(repository.existsById(userId))
		{
			 this.repository.save(details);
			 map.put("Message", "User credentials updated successfully.");
			 map.put("Status", HttpStatus.OK);
			 map.put("data", details);
		}
		else
		{
		     throw new EmployeeNotFoundException("User id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteStudent(String userId) {
		if(repository.existsById(userId))
		{
			this.repository.deleteById(userId);
			map.put("Message", "User information successfully deleted.");
			map.put("Status", HttpStatus.OK);
			map.put("data", "User Id : "+userId);
		}
		else
		{
			throw new EmployeeNotFoundException("user id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> updatePasswordByUserId(String userId, String newPassword) {
		if (repository.existsById(userId)) {
            repository.updatePasswordByUserId(userId, newPassword);
            map.put("Message", "Password has been updated successfully");
            map.put("Status", HttpStatus.OK);
            map.put("data", "User Name : "+userId+" "+" Password : "+newPassword);
            
        } else {
            throw new EmployeeNotFoundException("user id not found");
        }
		return map;
	}

}
