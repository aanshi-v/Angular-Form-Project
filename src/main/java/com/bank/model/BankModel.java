
package com.bank.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bank_table")
@EqualsAndHashCode
public class BankModel implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 5943098520145513739L;
	
	@Id
	@GeneratedValue(generator = "bank_table_customer_id_seq") 
	@Column(name = "customer_id")
	private Long customerId;
	
//	@Column(name = "income")
//	private Long income;
		
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mobile_no")
	private Integer mobileNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "aadhaar_no")
	private Integer aadhaarNo;
	
	@Column(name = "birth_certificate")
	private String birthCertificate;
	
	@Column(name = "salary_slips")
	private String salarySlips;
	
	@Column(name = "gstr_filing")
	private String gstrFiling;
	
	@CreationTimestamp
	@Column(name = "reg_date")
	private java.sql.Date regDate;
	
	@Column(name = "income5")
	private Long income5;

	@Column(name = "action")
	private String action;
	
	
}


