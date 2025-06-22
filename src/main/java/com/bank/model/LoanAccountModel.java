package com.bank.model;

import java.io.Serializable;

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
@Table(name = "locan_account")
@EqualsAndHashCode
public class LoanAccountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2011574128067629551L;
	
	@Id
	@GeneratedValue(generator = "loan_account_loan_id_seq") 
	@Column(name = "loan_id")
	private Integer loanId;
	
	@Column(name = "education_loan")
	private String educationLoan;
	
	@Column(name = "home_loan")
	private String homeLoan;
	
	@Column(name = "loan_amount")
	private Integer loanAmount;
	
	@Column(name = "duration")
	private Integer duration;
	

}
