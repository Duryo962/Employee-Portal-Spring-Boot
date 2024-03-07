package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.ShiftTimingsInformation;

public interface ShiftTimingService {
	
	Map<String, Object> findShiftById(Long employeeId);

	Map<String, Object> insertShiftTimingDetails(ShiftTimingsInformation entity);

	Map<String, Object> UpdateShiftTimings(Long id, ShiftTimingsInformation timingsEntity);

	Map<String, Object> DeleteShiftTimings(Long id);

	Map<String, Object> fetchingShiftsById(Long employeeId);

	Map<String, Object> fetchingShiftsByIdAndName(Long employeeId, String employeeName);

	Map<String, Object> fetchingShiftsByEmployeeName(String employeeName);
}