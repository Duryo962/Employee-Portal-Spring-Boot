package com.employeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.SkillsInformation;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsInformation, Long>{
	List<SkillsInformation> findByEmployeeId(Long employeeId);

}
