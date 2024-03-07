package com.employeePortal.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.SkillsInformation;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.repository.SkillsRepository;
import com.employeePortal.service.SkillsService;
@Service
public class SkillsServiceimpl implements SkillsService{
	
	@Autowired
	private SkillsRepository repository;
	
	Map<String,Object> map=new HashMap<>();

	@Override
	public Map<String, Object> GetSkillsById(Long employeeId) {
		if(employeeId !=null)
		{
			List<SkillsInformation> skillsInformation=this.repository.findByEmployeeId(employeeId);
			map.put("Message", "The skills Information has been successfully fetched.");
			map.put("Status", HttpStatus.OK);
			map.put("data", skillsInformation);
		}
		else
		{
			throw new EmployeeNotFoundException("EMployee id not found.");
		}
		return map;
	}

	@Override
	public Map<String, Object> InsertSkills(SkillsInformation skills) {
		this.repository.save(skills);
		map.put("Message", "Skills Information has been successfully uploaded.");
		map.put("Status", HttpStatus.OK);
		map.put("data", skills);
		return map;
	}

	@Override
	public Map<String, Object> UpdateSkill(Long id, SkillsInformation skills) {
		if(this.repository.existsById(id))
		{
			this.repository.save(skills);
			map.put("Message", "Selected Skill has been successfully updated.");
			map.put("Status",HttpStatus.OK);
			map.put("data", skills);
		}
		else
		{
			throw new EmployeeNotFoundException("Unique id not found");
	    }
		return map;
	}

	@Override
	public Map<String, Object> DeleteSkill(Long id) {
		if(this.repository.existsById(id))
		{
			this.repository.deleteById(id);
			map.put("Message", "Selected Skill has been successfully deleted.");
			map.put("Status",HttpStatus.OK);
			map.put("data", id);
		}
		else
		{
			throw new EmployeeNotFoundException("Unique id not found");
	    }
		return map;
		
		
	}

}
