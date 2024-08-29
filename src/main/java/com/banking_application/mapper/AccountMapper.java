package com.banking_application.mapper;

import com.banking_application.dto.Accountdto;
import com.banking_application.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(Accountdto accountdto) {
		
		Account account = new Account(
				
				accountdto.getId(),
				accountdto.getAccountHolderName(),
				accountdto.getBalance()
				
				);
				
			return account;	
	}
	
	public static Accountdto mapToAccountdto(Account account) {
		
		Accountdto accountdto = new Accountdto(
				
				account.getId(),
				account.getAccount_holder_name(),
				account.getBalance()
				
				);
				
		return accountdto;
	}
	
}
