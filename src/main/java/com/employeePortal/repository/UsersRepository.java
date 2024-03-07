package com.employeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeePortal.entity.UsersInformation;

@Repository
public interface UsersRepository extends JpaRepository<UsersInformation, String>{

	@Modifying
    @Query("UPDATE UsersInformation u SET u.password = :newPassword WHERE u.userId = :userId")
    void updatePasswordByUserId(String userId,  String newPassword);

}
