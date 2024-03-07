package com.employeePortal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortal.entity.NameValuePairInformation;
import com.employeePortal.service.NameValuePairService;

@RestController
@RequestMapping("/api/v1/namevaluepair")
@CrossOrigin("*")
public class NameValuePairController {
	
	@Autowired
	private NameValuePairService service;
	
	@GetMapping("/GetByTye/{Type}")
	public ResponseEntity<Map<String, Object>> GetByType(@PathVariable String Type)
	{
		Map<String, Object> map= this.service.getById(Type);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/InsertTypes")
	public ResponseEntity<Map<String, Object>> InsertTypes(@RequestBody NameValuePairInformation nameValuePair)
	{
		Map<String, Object> map= this.service.InsertTypes(nameValuePair);
		return ResponseEntity.ok(map);
	}

}
