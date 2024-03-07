package com.employeePortal.service;

import java.util.Map;

import com.employeePortal.entity.NameValuePairInformation;


public interface NameValuePairService {
	
	Map<String, Object> getById(String type);
	Map<String, Object> InsertTypes(NameValuePairInformation nameValuePair);

}
