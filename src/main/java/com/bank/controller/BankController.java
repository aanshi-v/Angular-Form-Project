package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.BankDto;
import com.bank.dto.BankResponseDto;
import com.bank.model.BankModel;
import com.bank.service.BankService;

@RestController
@Validated
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/bankController")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/test")
	public String Test(){
		return "BankController is working";
	}
	
	@PostMapping("/addCustomerRegistration")
	public ResponseEntity<BankResponseDto> addCustomerRegistration(@RequestBody BankDto bankDto) throws Exception{
		BankResponseDto bankResponseDto = bankService.addCustomerRegistration(bankDto);
		return new ResponseEntity<>(bankResponseDto, HttpStatus.CREATED);	
	}
	
	@PostMapping("/addDepositAccountOpening")
	public ResponseEntity<BankResponseDto> addDepositAccountOpening(@RequestBody BankDto bankDto) throws Exception{
		BankResponseDto bankResponseDto = bankService.addDepositAccountOpening(bankDto);
		return new ResponseEntity<>(bankResponseDto, HttpStatus.CREATED);	
	}
	
	@PostMapping("/loanAccountOpening")
	public ResponseEntity<BankResponseDto> loanAccountOpening(@RequestBody BankDto bankDto) throws Exception{
		BankResponseDto bankResponseDto = bankService.loanAccountOpening(bankDto);
		return new ResponseEntity<>(bankResponseDto, HttpStatus.CREATED);	
	}
	
	@GetMapping("/getRegDetails") 
	public List<BankDto> getRegDetails() throws Exception{
		return bankService.getRegDetails(); 	
	}
	
	@PostMapping("/getRegDetailsById") 
	public List<BankDto> getRegDetailsById(@RequestBody BankDto bankDto) throws Exception{
		return bankService.getRegDetailsById(bankDto); 	
	}

	
	@DeleteMapping("/deleteRegisDataById")
	public void deleteRegisDataById(@RequestParam Long customerId) throws Exception{
		 	bankService.deleteRegisDataById(customerId);
	}
	
	
	
//	@DeleteMapping("/deleteRegisDataById")
//	public ResponseEntity<BankResponseDto> deleteRegisDataById(@RequestParam Long customerId) throws Exception{
//		BankResponseDto bankResponseDto = bankService.deleteRegisDataById(customerId);
//		return new ResponseEntity<>(bankResponseDto, HttpStatus.OK);	
//	}
	
	
	@PutMapping("/updateRegsData")
	public BankModel updateRegsData(@RequestBody BankDto bankDto) throws Exception{
		return  bankService.updateRegsData(bankDto); 
	}

	
	
	
	
	
	
	
	
	
}
