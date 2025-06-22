package com.bank.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class BankDto {
	
	private Long customerId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Integer mobileNo;
	
	private String emailId;
	
	private Date dateOfBirth;
	
	private Integer aadhaarNo;
	
	private String birthCertificate;
	
	private String salarySlips;
	
	private String gstrFiling;
	
	private Integer depositAmount;
	private Integer duration;
	
	private String educationLoan;
	private String homeLoan;
	private Integer loanAmount;
	private java.sql.Date regDate;
	
//	private static final long FIVE_DAYS_IN_MILLISECONDS = 432000000L;
//	private long MIN10_IN_MILLISECONDS = 600000;
	
	

}
