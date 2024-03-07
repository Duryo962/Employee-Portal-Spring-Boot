package com.employeePortal.service;

import java.util.Map;


import com.employeePortal.entity.HolidaysInformation;


public interface HolidaysService {
	Map<String, Object> fetchHolidaysByYear(Integer year);

	Map<String, Object> insertHoliday(HolidaysInformation holiday);

}
