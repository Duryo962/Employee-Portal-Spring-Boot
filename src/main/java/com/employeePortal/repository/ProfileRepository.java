package com.employeePortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeePortal.dto.profileDto;
import com.employeePortal.entity.ProfileInformation;


import jakarta.transaction.Transactional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileInformation, Long>{
	
	@Modifying
    @Transactional
    @Query("UPDATE ProfileInformation p SET p.mobileNumber = :mobileNumber WHERE p.employeeID = :employeeId")
    void updateMobileNumber(@Param("employeeId") Long employeeId, @Param("mobileNumber") Long mobileNumber);

	Optional<ProfileInformation> findByEmployeeName(String type);
    
    @Modifying
    @Transactional
    @Query("UPDATE ProfileInformation p SET p.imageUrl = :imageUrl WHERE p.employeeID = :employeeId")
    void updateImageUrl(@Param("employeeId") Long employeeId, @Param("imageUrl") String imageUrl);
   
    @Query("SELECT pe.employeeID, pe.employeeName, pe.emailId FROM ProfileInformation pe WHERE pe.employeeID = :employeeId")
    Object[] getEmployeeDetailsById(Long employeeId);
    
    @Transactional
    @Modifying
    @Query("UPDATE ProfileInformation p SET p.about = :about WHERE p.employeeID = :employeeId")
    void updateAboutByEmployeeId(Long employeeId, String about);
    
    @Query("SELECT p.emailId FROM ProfileInformation p WHERE p.employeeID = :employeeID")
    String findEmailIdByEmployeeID(Long employeeID);
    
    @Modifying
    @Transactional
    @Query("UPDATE ProfileInformation p SET p.themeColor = :themeColor WHERE p.employeeID = :employeeId")
    void updateThemeColor(@Param("employeeId") Long employeeId, @Param("themeColor") String themeColor);
    
    @Query("SELECT p.employeeName FROM ProfileInformation p")
    List<String> findAllEmployeeNames();
    
    @Query("SELECT p FROM ProfileInformation p WHERE p.employeeID = :employeeID AND p.employeeName LIKE %:employeeName%")
    List<ProfileInformation> findByEmployeeIDAndEmployeeName(
            @Param("employeeID") Long employeeID, 
            @Param("employeeName") String employeeName);
    
    @Query("SELECT p FROM ProfileInformation p WHERE p.employeeID = :employeeID")
    List<ProfileInformation> findAllByEmployeeID(Long employeeID);
    
    @Query("SELECT p FROM ProfileInformation p WHERE p.employeeName LIKE %:employeeName%")
    List<ProfileInformation> findAllByEmployeeName(@Param("employeeName") String employeeName);
    
    @Transactional
    @Modifying
    @Query("UPDATE ProfileInformation p SET p.reportingManager = :newManager WHERE p.employeeID = :employeeId")
    void updateReportingManagerName(Long employeeId, String newManager);
    
    @Transactional
    @Modifying
    @Query("UPDATE ProfileInformation p SET p.shiftTimes = :shiftTimes WHERE p.employeeID = :employeeId")
    void updateShiftTimings(Long employeeId, String shiftTimes);
  

}
