package com.employeePortal.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.HolidaysInformation;
import com.employeePortal.exceptionHandling.BadRequestException;
import com.employeePortal.repository.HolidaysRepository;
import com.employeePortal.service.HolidaysService;
@Service
public class HolidaysServiceImpl implements HolidaysService{
	
	@Autowired
	private HolidaysRepository repository;
	
	Map<String, Object> map=new HashMap<>();

	@Override
	public Map<String, Object> fetchHolidaysByYear(Integer year) {
		if(year ==null || year==0)
		{
			throw new BadRequestException("Year not found. Please search using a valid year.");
		}
		List<HolidaysInformation> ResultHolidays=this.repository.findByHolidayYear(year);
		map.put("Message", "Holiday details successfully fetched.");
		map.put("Status", HttpStatus.FOUND);
		map.put("data", ResultHolidays);
		return map;
	}

	@Override
	public Map<String, Object> insertHoliday(HolidaysInformation holiday) {
		if(holiday.getDay()==null || holiday.getHoliDayDate()== null || holiday.getHolidayName()==null || holiday.getHolidayYear()==0)
		{
			throw new BadRequestException("The required fields are empty, so please fill in all the details and try again.");
		}
		this.repository.save(holiday);
		
		map.put("Message", "The details of the holidays have been successfully inserted.");
		map.put("Status", HttpStatus.CREATED);
		map.put("data", holiday);
		return map;
	}

}
