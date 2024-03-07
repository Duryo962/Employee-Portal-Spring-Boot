package com.employeePortal.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeePortal.dto.profileDto;
import com.employeePortal.entity.ProfileInformation;
import com.employeePortal.exceptionHandling.BadRequestException;
import com.employeePortal.exceptionHandling.EmployeeNotFoundException;
import com.employeePortal.imageCompresserDecompresser.CompressDecompressImage;
import com.employeePortal.repository.ProfileRepository;
import com.employeePortal.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileRepository repository;
	
	Map<String,Object> map=new HashMap<>();

	@Override
	public Map<String, Object> GetByEmployeeId(Long employeeID) {
		ProfileInformation information = this.repository.findById(employeeID)
			    .orElseThrow(() -> new EmployeeNotFoundException("Employee ID not found. Please search using a valid employee ID."));
		if(information.getImageUrl() !=null)
		{
			information.setImageUrl(CompressDecompressImage.decompressImage(information.getImageUrl()));
		}
		map.put("Message", "The profile information details have been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> getByEmployeeName(String employeeName) {
		ProfileInformation information=this.repository.findByEmployeeName(employeeName)
			.orElseThrow(() -> new EmployeeNotFoundException("Employee name not found. Please search using a valid employee name."));
		map.put("Message", "The profile information have been successfully fetched.");
		map.put("Status", HttpStatus.FOUND);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> UpdateMobileNumber(Long employeeId, Long mobileNumber) {
		if(employeeId==null)
		{
			throw new EmployeeNotFoundException("Employee ID not found");
		}
		else if(mobileNumber ==null)
		{
			throw new EmployeeNotFoundException("mobile Number not found");
		}
		this.repository.updateMobileNumber(employeeId, mobileNumber);
		map.put("Message", "Mobile number have been successfully updated");
		map.put("Status", HttpStatus.OK);
		map.put("data", "Employee ID : "+employeeId+" "+"Mobile Number : "+mobileNumber);
		return map;
	}

	@Override
	public Map<String, Object> getEmployeeDetailsById(Long employeeId) {
		ProfileInformation information = this.repository.findById(employeeId)
			    .orElseThrow(() -> new EmployeeNotFoundException("Employee ID not found. Please search using a valid employee ID."));
		if(information.getImageUrl() !=null)
		{
			information.setImageUrl(CompressDecompressImage.decompressImage(information.getImageUrl()));
		}
		map.put("Message", "The profile information details have been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> findAllEmployees() {
		List<ProfileInformation> information=this.repository.findAll();
		map.put("Message", "All employee details have been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> updateAboutByEmployeeId(Long employeeId, String about) {
		if(employeeId==null)
		{
			throw new EmployeeNotFoundException("The employee Id not found");
		}
		else if(about==null)
		{
			throw new BadRequestException("About information not found");
		}
		this.repository.updateAboutByEmployeeId(employeeId, about);
		map.put("Message", "The about information has been successfully updated.");
		map.put("Status", HttpStatus.OK);
		map.put("data", "Employee Id : "+employeeId+" About : "+about);
		return map;
	}

	@Override
	public Map<String, Object> uploadImage(Long employeeId, MultipartFile image) throws IOException {
			ProfileInformation existingProfile = repository.findById(employeeId)
			        .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + employeeId + " not found"));

            if (existingProfile != null) {
                    existingProfile.setImageUrl(CompressDecompressImage.compressImage(image.getBytes()));
                    repository.save(existingProfile);
                    map.put("Message", "The profile image have been successfully updated.");
                    map.put("Status", HttpStatus.OK);    
            }
        
		return map;
	}

	@Override
	public Map<String, Object> getEmailIdByEmployeeID(Long employeeID) {
		if(repository.existsById(employeeID))
		{
			 String emailId=this.repository.findEmailIdByEmployeeID(employeeID);
			 map.put("Message", "The email ID has been successfully fetched.");
			 map.put("Status", HttpStatus.OK);
			 map.put("data", emailId);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> UpdateThemeCOlor(Long employeeId, String themeColor) {
		// TODO Auto-generated method stub
		if(this.repository.existsById(employeeId))
		{
			ProfileInformation profile=this.repository.findById(employeeId).orElse(null);
			profile.setThemeColor('#'+themeColor);
			this.repository.save(profile);
			map.put("Message", "Theme color has been successfully updated.");
			map.put("Status", HttpStatus.OK);
			map.put("data", "Employee ID : "+employeeId+" Theme Color : "+"#"+themeColor);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Id not found");
		}
		return map;
	}

	@Override
	public Map<String, Object> getAllEmployeesNames() {
		List<String> listOfEmployeesNames=this.repository.findAllEmployeeNames();
		map.put("Message", "All employees names has been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", listOfEmployeesNames);
		
		return map;
	}

	@Override
	public Map<String, Object> InsertEMployee(ProfileInformation information) {
		if(repository.existsById(information.getEmployeeID()))
		{
			throw new EmployeeNotFoundException("Employee ID already exists.");
		}
		this.repository.save(information);
		map.put("Message", "Employee information has been successfully uploaded.");
		map.put("Status", HttpStatus.CREATED);
		map.put("data", information);
		return map;
	}

	@Override
	public Map<String, Object> getEmployeeDataByIdAndPassword(Long employeeId, String employeeName) {
		List<ProfileInformation> profile=this.repository.findByEmployeeIDAndEmployeeName(employeeId, employeeName);
		map.put("Message", "Employee information has been successfully Fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", profile);
		return map;
	}

	@Override
	public Map<String, Object> findAllemployeesById(Long employeeId) {
	
		List<ProfileInformation> profile=this.repository.findAllByEmployeeID(employeeId);
		map.put("Message", "Employee information has been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", profile);
		return map;
	}

	@Override
	public Map<String, Object> findAllemployeesByName(String employeeName) {
		List<ProfileInformation> profile=this.repository.findAllByEmployeeName(employeeName);
		map.put("Message", "Employee information has been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", profile);
		return map;
	}

	@Override
	public Map<String, Object> UpdateProfileById(ProfileInformation information) {
		ProfileInformation profile = this.repository.findById(information.getEmployeeID())
			    .orElseThrow(() -> new EmployeeNotFoundException("Employee ID not found. Please search using a valid employee ID."));
		profile.setEmployeeName(information.getEmployeeName());
		profile.setDateOfJoining(information.getDateOfJoining());
	    profile.setEmailId(information.getEmailId());
	    profile.setDesignation(information.getDesignation());
	    profile.setMobileNumber(information.getMobileNumber());
	    this.repository.save(profile);
	    map.put("Message", "Employee information has been successfully Updated.");
		map.put("Status", HttpStatus.OK);
		map.put("data", profile);
		return map;
	}

	@Override
	public Map<String, Object> UpdateReportingManagerNameByEmpId(Long employeeId, String reportingManager) {
		if(this.repository.existsById(employeeId))
		{
			this.repository.updateReportingManagerName(employeeId, reportingManager);
			map.put("Message", "Reporting Manager has been successfully Updated.");
			map.put("Status", HttpStatus.OK);
			
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Id not found.");
		}
		return map;
	}

	@Override
	public Map<String, Object> UpdateShiftTimingsByEmpId(Long employeeId, String shiftTimes) {
		if(this.repository.existsById(employeeId))
		{
			this.repository.updateShiftTimings(employeeId, shiftTimes);
			map.put("Message", "Shift timings has been successfully Updated.");
			map.put("Status", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Id not found.");
		}
		return map;
	}

	

	

	

	

}
