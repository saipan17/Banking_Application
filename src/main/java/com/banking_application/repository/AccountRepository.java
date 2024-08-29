package com.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking_application.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
   
	     
}
