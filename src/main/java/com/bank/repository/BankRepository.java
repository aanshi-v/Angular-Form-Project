package com.bank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.model.BankModel;

@Repository
public interface BankRepository extends JpaRepository<BankModel, Long> {

//	Object findByFields(Integer mobileNo, Integer aadhaarNo, String emailId); 

	@Query("select b from BankModel b where b.mobileNo = :mobileNo and b.aadhaarNo = :aadhaarNo and b.emailId = :emailId")
	BankModel findByFields(Integer mobileNo, Integer aadhaarNo, String emailId);

	@Query("select b from BankModel b where b.mobileNo = :mobileNo")
	BankModel findByMobileNo(Integer mobileNo);

	@Query("select b from BankModel b where b.aadhaarNo = :aadhaarNo")
	BankModel findByAadhaarNo(Integer aadhaarNo);

	@Query("select b from BankModel b where b.emailId = :emailId")
	BankModel findByEmail(String emailId);

	long countByRegDate(LocalDate today);

	@Query("select b from BankModel b where b.customerId = :customerId") 
	List<BankModel> findByCustomerId(Long customerId); 

	

	

	
	
//	@Modifying
//	@Query(value = "update BankModel b set income5 = 5006 where b.customerId = :customerId", nativeQuery = true)
//	void updateIncome(Long customerId);  


 
	
	

}
