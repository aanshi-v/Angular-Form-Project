package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.LoanAccountModel;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccountModel, Integer> {

}
