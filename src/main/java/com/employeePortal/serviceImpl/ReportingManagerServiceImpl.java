package com.employeePortal.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.ReportingManagerInformation;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.repository.ReportingManagerRepository;
import com.employeePortal.service.ReportingManagerService;
@Service
public class ReportingManagerServiceImpl implements ReportingManagerService{
	
	@Autowired
	private ReportingManagerRepository repository;
	
	
	Map<String,Object> map=new HashMap<>();
	
	@Override
	public Map<String, Object> findReportingManagerById(Long employeeId) {
		if(employeeId ==null)
		{
			throw new EmployeeNotFoundException("Employee id not found");
		}
		List<ReportingManagerInformation> rmInformation=this.repository.findReportingMangerDetailsById(employeeId);
		map.put("Message", "The reporting manager details has been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", rmInformation);
		return map;
	}

	@Override
	public Map<String, Object> UpdateManagerDetailsById(ReportingManagerInformation managerDetails) {
		if(this.repository.existsById(managerDetails.getId()))
		{
			ReportingManagerInformation rmDeatils=this.repository.findById(managerDetails.getId()).orElse(null);
			rmDeatils.setEndDate(managerDetails.getEndDate());
			rmDeatils.setStartDate(managerDetails.getStartDate());
			rmDeatils.setModifiedDate(managerDetails.getModifiedDate());
			rmDeatils.setManagerName(managerDetails.getManagerName());
			rmDeatils.setModifiedBy(managerDetails.getModifiedBy());
			rmDeatils.setId(managerDetails.getId());
			rmDeatils.setEmployeeId(managerDetails.getEmployeeId());
			rmDeatils.setEmployeeName(managerDetails.getEmployeeName());
			this.repository.save(rmDeatils);
			map.put("Message", "Reporting manager information has been successfully updated.");
			map.put("Status", HttpStatus.OK);
			map.put("data", rmDeatils);
		}
		else
		{
			throw new EmployeeNotFoundException("EMployee id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> createReportingManager(ReportingManagerInformation managerInformation) {
		this.repository.save(managerInformation);
		map.put("Message", "Reporting manager information has been successfully uploaded");
		map.put("Status", HttpStatus.CREATED);
		map.put("data", managerInformation);
		return map;
	}

	@Override
	public Map<String, Object> deleteReoortingManager(long id) {
		this.repository.deleteById(id);
		map.put("Message", "Reporting manager information has been successfully deleted");
		map.put("Status", HttpStatus.OK);
		return map;
	}

	@Override
	public Map<String, Object> findAllbyEmpId(Long employeeId) {
		List<ReportingManagerInformation> information=this.repository.findAllRMByEmployeeID(employeeId);
		map.put("Message", "Reporting manager information has been successfully Fetched");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> findAllbyEmpName(String employeeName) {
		List<ReportingManagerInformation> information=this.repository.findAllRMByEmployeeName(employeeName);
		map.put("Message", "Reporting manager information has been successfully Fetched");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> findAllbyEmpNameAndId(Long employeeId, String employeeName) {
		List<ReportingManagerInformation> information=this.repository.findRMByEmployeeIDAndEmployeeName(employeeId,employeeName);
		map.put("Message", "Reporting manager information has been successfully Fetched");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

}
