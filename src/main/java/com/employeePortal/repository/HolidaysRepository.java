package com.employeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.HolidaysInformation;

@Repository
public interface HolidaysRepository extends JpaRepository<HolidaysInformation, Long>{
	
	List<HolidaysInformation> findByHolidayYear(Integer year);

}
