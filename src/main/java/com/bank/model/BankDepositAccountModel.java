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
@Table(name = "deposit_account")
@EqualsAndHashCode
public class BankDepositAccountModel implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 7484204621901960724L;
	
	@Id
	@GeneratedValue(generator = "deposit_account_deposit_id_seq") 
	@Column(name = "deposit_id")
	private Integer depositId;
	
	@Column(name = "deposit_amount")
	private Integer depositAmount;
	
	@Column(name = "duration")
	private Integer duration;

}
