package com.banking_application.service;
import com.banking_application.dto.*;
import java.util.List;

public interface  AccountService {

	    Accountdto createAccount(Accountdto accountdto);
	   
	    Accountdto getAccountById(long id);
	    
	    Accountdto deposit(long id , double amount);
	    
	    Accountdto withdraw(long id , double amount);
	    
	    List< Accountdto> getAllAccounts();
	    
	    void deleteAccount(long id);
}
