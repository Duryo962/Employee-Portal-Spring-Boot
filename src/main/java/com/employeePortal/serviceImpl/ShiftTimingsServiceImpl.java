package com.employeePortal.serviceImpl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.ShiftTimingsInformation;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.repository.ShiftTimingsRepository;
import com.employeePortal.service.ShiftTimingService;

@Service
public class ShiftTimingsServiceImpl implements ShiftTimingService{
	
	@Autowired
	private ShiftTimingsRepository repository;
	
	Map<String,Object> map=new HashMap<>();
	
	@Override
	public Map<String, Object> findShiftById(Long employeeId) {
		if(employeeId == null)
		{
			throw new EmployeeNotFoundException("Employee id not found");
		}
		List<ShiftTimingsInformation> timingsInformation=this.repository.findByEmployeeId(employeeId);
		map.put("Message", "Shift timing information successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", timingsInformation);
		return map;
	}

	@Override
	public Map<String, Object> insertShiftTimingDetails(ShiftTimingsInformation entity) {
		this.repository.save(entity);
		map.put("Message", "Shift timing information has been successfully uploaded.");
		map.put("Status", HttpStatus.OK);
		map.put("data", entity);
		return map;
	}

	@Override
	public Map<String, Object> UpdateShiftTimings(Long id,ShiftTimingsInformation timingsEntity) {
		if(this.repository.existsById(id))
		{
			ShiftTimingsInformation entityData= this.repository.findById(id).orElse(timingsEntity);
			entityData.setEmployeeId(timingsEntity.getEmployeeId());
			entityData.setEmployeeName(timingsEntity.getEmployeeName());
			entityData.setEndDate(timingsEntity.getEndDate());
			entityData.setModifiedBy(timingsEntity.getModifiedBy());
			entityData.setModifiedDate(timingsEntity.getModifiedDate());
			entityData.setShiftEndTime(timingsEntity.getShiftEndTime());
			entityData.setShiftStartTime(timingsEntity.getShiftStartTime());
			entityData.setWeekOffDays(timingsEntity.getWeekOffDays());
			entityData.setStartDate(timingsEntity.getStartDate());
			this.repository.save(entityData);
			map.put("Message", "Shift timing information has been successsfully updated.");
			map.put("Status", HttpStatus.OK);
			map.put("data", entityData);
		}
		else
		{
			throw new EmployeeNotFoundException("Emloyee id not found.");
		}
		return map;
	}

	@Override
	public Map<String, Object> DeleteShiftTimings(Long id) {
		if(repository.existsById(id))
		{
			this.repository.deleteById(id);;
			map.put("Message", "Shift timing information has been successsfully deleted.");
			map.put("Status", HttpStatus.OK);
			map.put("data", id);
		}
		else
		{
			throw new EmployeeNotFoundException("Unique Id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> fetchingShiftsById(Long employeeId) {
		List<ShiftTimingsInformation> information=this.repository.findAllShiftsByEmployeeID(employeeId);
		map.put("Message", "Shift timing information has been successsfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> fetchingShiftsByIdAndName(Long employeeId, String employeeName) {
		List<ShiftTimingsInformation> information=this.repository.findShiftsByEmployeeIDAndEmployeeName(employeeId,employeeName);
		map.put("Message", "Shift timing information has been successsfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> fetchingShiftsByEmployeeName(String employeeName) {
		List<ShiftTimingsInformation> information=this.repository.findAllShiftsByEmployeeName(employeeName);
		map.put("Message", "Shift timing information has been successsfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

}
