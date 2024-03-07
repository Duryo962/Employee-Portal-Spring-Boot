package com.employeePortal.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.LeaveDetailsInformation;

import jakarta.transaction.Transactional;

@Repository
public interface LeavesInformationRepository extends JpaRepository<LeaveDetailsInformation, Long>{
	
	 List<LeaveDetailsInformation> findByEmployeeId(Long employeeID);
	    List<LeaveDetailsInformation> findByEmployeeIdAndLeaveFromDateBetween(Long employeeId, Date startDate, Date endDate);
	    List<LeaveDetailsInformation> findByReportingManagerAndLeaveStatus(String reportingManager, String leaveStatus);

	    @Transactional
	    @Modifying
	    @Query("UPDATE LeaveDetailsInformation e SET e.leaveStatus = :leaveStatus WHERE e.uniqueNumber = :uniqueNumber")
	    void updateLeaveStatusById(Long uniqueNumber, String leaveStatus);

}
