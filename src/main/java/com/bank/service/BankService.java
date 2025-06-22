package com.bank.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.constants.BankConstants;
import com.bank.dto.BankDto;
import com.bank.dto.BankResponseDto;
import com.bank.model.BankDepositAccountModel;
import com.bank.model.BankModel;
import com.bank.model.LoanAccountModel;
import com.bank.repository.BankDepositAccountRepository;
import com.bank.repository.BankRepository;
import com.bank.repository.LoanAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private BankDepositAccountRepository bankDepositAccountRepository;
	
	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	
	@Transactional
	public BankResponseDto addCustomerRegistration(BankDto bankDto) throws Exception{
		
		BankResponseDto bankResponseDto = new BankResponseDto();
//		BankResponseDto bankResponseDto = new BankResponseDto(null, null);
		BankModel bankModel = new BankModel();
		try {
			LocalDate today = LocalDate.now();
			System.out.println("Today's Date: " + today);
			System.out.println("==============================================================================================");

			long usersRegisteredToday = bankRepository.countByRegDate(today);
			if (usersRegisteredToday >= 5) {
				 bankResponseDto.setMessage(BankConstants.MAXREG);
	            return bankResponseDto;
	        }
			
			if(bankRepository.findByFields(bankDto.getMobileNo(), bankDto.getAadhaarNo(), bankDto.getEmailId()) == null) {
				if(bankRepository.findByMobileNo(bankDto.getMobileNo()) == null) {
					if(bankRepository.findByAadhaarNo(bankDto.getAadhaarNo()) == null) {
						if(bankRepository.findByEmail(bankDto.getEmailId()) == null) {
							
							bankModel.setFirstName(bankDto.getFirstName());
							bankModel.setMiddleName(bankDto.getMiddleName());
							bankModel.setLastName(bankDto.getLastName());
							bankModel.setMobileNo(bankDto.getMobileNo());
							bankModel.setEmailId(bankDto.getEmailId());
							bankModel.setDateOfBirth(bankDto.getDateOfBirth());
							bankModel.setAadhaarNo(bankDto.getAadhaarNo());
							bankModel.setBirthCertificate(bankDto.getBirthCertificate());
							bankModel.setSalarySlips(bankDto.getSalarySlips());
							bankModel.setGstrFiling(bankDto.getGstrFiling());
							bankModel.setAction(BankConstants.SAVE); 
							
							
//							Long income5 = this.generatedIncome();

//						   bankModel.setIncome5(income5); 
//						   bankRepository.updateIncome(bankDto.getCustomerId());
//						   bankRepository.updateIncome((long) 15214);
							
								
							bankRepository.save(bankModel);
							bankResponseDto.setIsSubmitted(true);
							bankResponseDto.setMessage(BankConstants.REG_SUCCESS);
							
						}else {
							bankResponseDto.setIsSubmitted(false);
							bankResponseDto.setMessage(BankConstants.EMAIL_ALREADY_PRESENT);
						}	
					}else {
						bankResponseDto.setIsSubmitted(false);
						bankResponseDto.setMessage(BankConstants.AADHAAR_ALREADY_PRESENT);
					}		
				}else {
					bankResponseDto.setIsSubmitted(false);
					bankResponseDto.setMessage(BankConstants.Mob_ALREADY_PRESENT);
				}				
			}else {
				bankResponseDto.setIsSubmitted(false);
				bankResponseDto.setMessage(BankConstants.DATA_ALREADY_PRESENT); 
			}		
		} catch (Exception e) {
			throw new Exception(BankConstants.POST_FAILURE_MESSAGE, e);
		}	
		return bankResponseDto;	
	}
	
	
	

//	@Scheduled(fixedRate = 6000)
//	protected Long generatedIncome() { 
//		return (long) 5000;
//	} 
	
//	@Scheduled(fixedRate = 6000)
//	protected long generatedIncome() { 
//		System.out.println("Scheduler running");
//		return (5000);
//	}
	

	
//	@Scheduled(fixedRate = 4000)
//	public void testScheduler() {
//		System.out.println("Scheduler running");
//	}
	
//	@Scheduled(fixedRate = 4000)
//	public void testScheduler() {
//		for(int i=1; i<4; i++) {
//			System.out.println("Scheduler running:"+ i);
//		}
//	}




	@Transactional
	public BankResponseDto addDepositAccountOpening(BankDto bankDto) throws Exception{
		
		BankResponseDto bankResponseDto = new BankResponseDto();
		BankDepositAccountModel bankDepositAccountModel = new BankDepositAccountModel();
		try {
			bankDepositAccountModel.setDepositAmount(bankDto.getDepositAmount());
			bankDepositAccountModel.setDuration(bankDto.getDuration());
			
			bankDepositAccountRepository.save(bankDepositAccountModel);
				bankResponseDto.setIsSubmitted(true);
				bankResponseDto.setMessage(BankConstants.REQUEST_LOGGED_SUCCESS);				
				
		} catch (Exception e) {
			throw new Exception(BankConstants.POST_FAILURE_MESSAGE, e);
		}	
		return bankResponseDto;	
	}
	
	
	
	@Transactional
	public BankResponseDto loanAccountOpening(BankDto bankDto) throws Exception{
		
		BankResponseDto bankResponseDto = new BankResponseDto();
		LoanAccountModel loanAccountModel = new LoanAccountModel();
		try {
			loanAccountModel.setEducationLoan(bankDto.getEducationLoan());
			loanAccountModel.setHomeLoan(bankDto.getHomeLoan());
			loanAccountModel.setLoanAmount(bankDto.getLoanAmount());
			loanAccountModel.setDuration(bankDto.getDuration());
			
			loanAccountRepository.save(loanAccountModel);
				bankResponseDto.setIsSubmitted(true);
				bankResponseDto.setMessage(BankConstants.REQUEST_LOGGED_SUCCESS);				
				
		} catch (Exception e) {
			throw new Exception(BankConstants.POST_FAILURE_MESSAGE, e);
		}	
		return bankResponseDto;	
	}
	
	
	
	public List<BankDto> getRegDetails() throws Exception{
		List<BankDto> bankDoList = new ArrayList<>();
		try {
			List<BankModel> bankModelList = bankRepository.findAll();
			bankModelList.forEach(regList -> {
				BankDto bankdDto = new BankDto();
				bankdDto.setCustomerId(regList.getCustomerId());
				bankdDto.setFirstName(regList.getFirstName());
				bankdDto.setMiddleName(regList.getMiddleName());
				bankdDto.setLastName(regList.getLastName());
				bankdDto.setMobileNo(regList.getMobileNo());
				bankdDto.setEmailId(regList.getEmailId());
				bankdDto.setDateOfBirth(regList.getDateOfBirth());
				bankdDto.setAadhaarNo(regList.getAadhaarNo());
				bankdDto.setBirthCertificate(regList.getBirthCertificate());
				bankdDto.setSalarySlips(regList.getSalarySlips());
				bankdDto.setGstrFiling(regList.getGstrFiling());
				bankdDto.setRegDate(regList.getRegDate());
				
				bankDoList.add(bankdDto);
			});
		} catch (Exception e) {
			throw new Exception(BankConstants.ERROR, e);
		}
		return bankDoList;
	}
	
	public List<BankDto> getRegDetailsById(BankDto bankDto) throws Exception{
		List<BankDto> bankDoList = new ArrayList<>();
		try {
			List<BankModel> bankModelList = bankRepository.findByCustomerId(bankDto.getCustomerId());
		
			bankModelList.forEach(regList -> {
				BankDto bankdDto = new BankDto();
				bankdDto.setCustomerId(regList.getCustomerId());
				bankdDto.setFirstName(regList.getFirstName());
				bankdDto.setMiddleName(regList.getMiddleName());
				bankdDto.setLastName(regList.getLastName());
				bankdDto.setMobileNo(regList.getMobileNo());
				bankdDto.setEmailId(regList.getEmailId());
				bankdDto.setDateOfBirth(regList.getDateOfBirth());
				bankdDto.setAadhaarNo(regList.getAadhaarNo());
				bankdDto.setBirthCertificate(regList.getBirthCertificate());
				bankdDto.setSalarySlips(regList.getSalarySlips());
				bankdDto.setGstrFiling(regList.getGstrFiling());
				bankdDto.setRegDate(regList.getRegDate());
				
				bankDoList.add(bankdDto);
			});
		} catch (Exception e) {
			throw new Exception(BankConstants.ERROR, e);
		}
		return bankDoList;
	}


	
	public void deleteRegisDataById(Long customerId) throws Exception{
		try {
			bankRepository.deleteById(customerId); 
			
		} catch (Exception e) {
			throw new Exception(BankConstants.ERROR, e);
		}
	}
	
//	public BankResponseDto deleteRegisDataById(Long customerId) throws Exception{
//		BankResponseDto bankResponseDto = new BankResponseDto();
//		try {
//			bankRepository.deleteById(customerId); 
//			bankResponseDto.setIsSubmitted(true);
//			bankResponseDto.setMessage(BankConstants.DEL_SUCCESS);
//			
//		} catch (Exception e) {
//			throw new Exception(BankConstants.ERROR, e);
//		}
//		return bankResponseDto;
//	}
	
	
	
	
	
	public BankModel updateRegsData(BankDto bankDto) throws Exception{
		
			Long customerId = bankDto.getCustomerId();
			BankModel bankModel = bankRepository.findById(customerId).get();
			bankModel.setFirstName(bankDto.getFirstName());
			bankModel.setMiddleName(bankDto.getMiddleName());
			bankModel.setLastName(bankDto.getLastName());
			bankModel.setMobileNo(bankDto.getMobileNo());
			bankModel.setEmailId(bankDto.getEmailId());
			bankModel.setDateOfBirth(bankDto.getDateOfBirth());
			bankModel.setAadhaarNo(bankDto.getAadhaarNo());
			bankModel.setBirthCertificate(bankDto.getBirthCertificate());
			bankModel.setSalarySlips(bankDto.getSalarySlips());
			bankModel.setGstrFiling(bankDto.getGstrFiling());
			bankModel.setAction(BankConstants.UPDATE);
			
			return  bankRepository.save(bankModel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
