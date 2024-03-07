package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.SkillsInformation;

public interface SkillsService {
	
	Map<String, Object> GetSkillsById(Long employeeId);
	Map<String, Object> InsertSkills(SkillsInformation skills);
	Map<String, Object> UpdateSkill(Long id, SkillsInformation skills);
	Map<String, Object> DeleteSkill(Long id);

}
