package com.employeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.ProfileInformation;
import com.employeePortal.entity.ReportingManagerInformation;


@Repository
public interface ReportingManagerRepository extends JpaRepository<ReportingManagerInformation, Long>{
	 @Query("SELECT r FROM ReportingManagerInformation r WHERE r.employeeId = :employeeId")
	    List<ReportingManagerInformation> findReportingMangerDetailsById(Long employeeId);
	 
	 @Query("SELECT p FROM ReportingManagerInformation p WHERE p.employeeId = :employeeId")
	    List<ReportingManagerInformation> findAllRMByEmployeeID(@Param("employeeId") Long employeeId);

	    @Query("SELECT p FROM ReportingManagerInformation p WHERE p.employeeName LIKE %:employeeName%")
	    List<ReportingManagerInformation> findAllRMByEmployeeName(@Param("employeeName") String employeeName);

	    @Query("SELECT p FROM ReportingManagerInformation p WHERE p.employeeId = :employeeId AND p.employeeName LIKE %:employeeName%")
	    List<ReportingManagerInformation> findRMByEmployeeIDAndEmployeeName(
	            @Param("employeeId") Long employeeId, 
	            @Param("employeeName") String employeeName);
}
