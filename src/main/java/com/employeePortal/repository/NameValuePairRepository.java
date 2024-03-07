package com.employeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.NameValuePairInformation;

@Repository
public interface NameValuePairRepository extends JpaRepository<NameValuePairInformation, Long>{
	
	List<NameValuePairInformation> findByType(String type);

}
