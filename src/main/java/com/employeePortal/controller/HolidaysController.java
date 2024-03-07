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

import com.employeePortal.entity.HolidaysInformation;
import com.employeePortal.service.HolidaysService;

@RestController
@RequestMapping("/api/v1/holidays")
@CrossOrigin("*")
public class HolidaysController {
	
	@Autowired
	private HolidaysService service;
	
	@GetMapping("/fetchByYear/{year}")
    public ResponseEntity<Map<String, Object>> fetchHolidaysByYear(@PathVariable Integer year) {
      Map<String,Object> map= this.service.fetchHolidaysByYear(year);
      return ResponseEntity.ok(map);
    }

    @PostMapping("/insert")
    public ResponseEntity<Map<String,Object>> insertHoliday(@RequestBody HolidaysInformation holiday) {
        Map<String,Object> map= this.service.insertHoliday(holiday);
        return ResponseEntity.ok(map);
    }

}
