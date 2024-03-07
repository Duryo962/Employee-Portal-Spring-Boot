package com.employeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.ReportingManagerInformation;
import com.employeePortal.entity.ShiftTimingsInformation;

@Repository
public interface ShiftTimingsRepository extends JpaRepository<ShiftTimingsInformation, Long>{
	List<ShiftTimingsInformation> findByEmployeeId(Long employeeId);
	
	 @Query("SELECT p FROM ShiftTimingsInformation p WHERE p.employeeId = :employeeId")
	    List<ShiftTimingsInformation> findAllShiftsByEmployeeID(@Param("employeeId") Long employeeId);

	    @Query("SELECT p FROM ShiftTimingsInformation p WHERE p.employeeName LIKE %:employeeName%")
	    List<ShiftTimingsInformation> findAllShiftsByEmployeeName(@Param("employeeName") String employeeName);

	    @Query("SELECT p FROM ShiftTimingsInformation p WHERE p.employeeId = :employeeId AND p.employeeName LIKE %:employeeName%")
	    List<ShiftTimingsInformation> findShiftsByEmployeeIDAndEmployeeName(
	            @Param("employeeId") Long employeeId, 
	            @Param("employeeName") String employeeName);

}
