package com.employeePortal.serviceImpl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeePortal.entity.NameValuePairInformation;
import com.employeePortal.exceptionHandling.BadRequestException;
import com.employeePortal.repository.NameValuePairRepository;
import com.employeePortal.service.NameValuePairService;
@Service
public class NameValuepairServiceImpl implements NameValuePairService{
	
	@Autowired
	private NameValuePairRepository repository;
	
	 private Map<String, Object> map;

	@Override
	public Map<String, Object> getById(String type) {
		if(type==null)
		{
			throw new BadRequestException("The type is not found in the name-value pair");
		}
		List<NameValuePairInformation> nameValuePairresult=this.repository.findByType(type);
		map = new HashMap<>();
		
		map.put("Message", "The details for name value pair have been successfully fetched.");
		map.put("Status", HttpStatus.OK);
		map.put("data", nameValuePairresult);
		return map;
	}

	@Override
	public Map<String, Object> InsertTypes(NameValuePairInformation nameValuePair) {
		if(nameValuePair.getName()==null)
		{
			throw new BadRequestException("The name was not found. Please enter a valid name.");
		}
		else if(nameValuePair.getType()==null )
		{
			throw new BadRequestException("The Type was not found. Please enter a valid name.");
		}
		else if( nameValuePair.getValue()==null)
		{
			throw new BadRequestException("The Value was not found. Please enter a valid name.");
		}
		map = new HashMap<>();
		this.repository.save(nameValuePair);
		map.put("Message", "The name-value pair details have been successfully inserted.");
		map.put("Status", HttpStatus.CREATED);
		map.put("data", nameValuePair);
		return map;
	}

}
