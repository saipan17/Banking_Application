package com.banking_application.service.impl;
import com.banking_application.service.*;
import java.util.stream.*;

import org.springframework.stereotype.Service;
import java.util.List;

import com.banking_application.dto.Accountdto;
import com.banking_application.entity.Account;
import com.banking_application.mapper.AccountMapper;
import com.banking_application.repository.AccountRepository;

@Service
public class AccountServiceImpl  implements AccountService{

	private AccountRepository  accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Accountdto createAccount(Accountdto accountdto) {
		
		Account account = AccountMapper.mapToAccount(accountdto);
		
         Account savedAccount = accountRepository.save(account);
              
		  return AccountMapper.mapToAccountdto(savedAccount);
	}

	@Override
	public Accountdto getAccountById(long id) {
		
		Account account = accountRepository.findById(id).orElseThrow( ( ) -> new RuntimeException("account not exist") );
		
		return AccountMapper.mapToAccountdto(account);
	}

	@Override
	public Accountdto deposit(long id, double amount) {
		
	Account account = accountRepository.findById(id).orElseThrow( ( ) -> new RuntimeException("account not exist") );
	
	double totalBalance = account.getBalance() + amount ;

	account.setBalance(totalBalance);
	
	Account savedAccount = accountRepository.save(account);
		
	return AccountMapper.mapToAccountdto(savedAccount);
	}
	
	@Override
	public Accountdto withdraw(long id , double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow( ( ) -> new RuntimeException("account not exist") );

		try {
			
			if(account.getBalance()<amount) {
				
				throw new RuntimeException("Insufficient Balance");
			}
		}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
	
		double totalBalance = account.getBalance()-amount;
		account.setBalance(totalBalance);
		 
		 Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountdto(savedAccount);
	}

	@Override
	public List<Accountdto> getAllAccounts() {
	    return accountRepository.findAll().stream()
	                            .map(AccountMapper::mapToAccountdto)
	                            .collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
	
		Account account = accountRepository.findById(id).orElseThrow( ( ) -> new RuntimeException("account not exist") );
		
		accountRepository.delete(account);
		
	}

}
