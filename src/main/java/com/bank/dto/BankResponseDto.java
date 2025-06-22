package com.bank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankResponseDto {
	
	private Boolean isSubmitted;
	private String message;
	
	public BankResponseDto(Boolean isSubmitted, String message) {
		super();
		this.isSubmitted = isSubmitted;
		this.message = message;
	}

}
