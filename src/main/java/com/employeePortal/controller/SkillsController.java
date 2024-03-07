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

import com.employeePortal.entity.SkillsInformation;
import com.employeePortal.service.SkillsService;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin("*")
public class SkillsController {
	
	@Autowired
	private SkillsService service;
	
	@GetMapping("/GetSkillsById/{employeeId}")
	public ResponseEntity<Map<String, Object>> getSkillsById(@PathVariable long employeeId)
	{
		Map<String, Object> map= this.service.GetSkillsById(employeeId);
		return ResponseEntity.ok(map);
	}
	@PostMapping("/InsertSklls")
	public ResponseEntity<Map<String, Object>> insertSkill(@RequestBody SkillsInformation  skills)
	{
		Map<String, Object> map= this.service.InsertSkills(skills);
		return ResponseEntity.ok(map);
	}
	@PutMapping("/UpdateSkills/{id}")
	public ResponseEntity<Map<String, Object>> UpdateSkill(@PathVariable Long id, @RequestBody SkillsInformation skills)
	{
		Map<String, Object> map= this.service.UpdateSkill(id,skills);
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/DeleteSkill/{id}")
	public ResponseEntity<Map<String, Object>> deleteSkillData(@PathVariable(name = "id") Long id)
	{
		Map<String, Object> map= this.service.DeleteSkill(id);
		return ResponseEntity.ok(map);
	}
	

}
