package com.banking_application.controller;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking_application.dto.Accountdto;
import com.banking_application.service.AccountService;

@Controller
@RequestMapping("/api/accounts")
public class AccountController {

	 @Autowired
	   private AccountService accountService;
	   
	 @PostMapping
	   public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
		   return new ResponseEntity<>(accountService.createAccount(accountdto) ,HttpStatus.CREATED );
	   }
	   
	 @GetMapping("/{id}")
	 public ResponseEntity<Accountdto> getAccount(@PathVariable long id){
		 
		 Accountdto accountdto = accountService.getAccountById(id);
		 
		 return  ResponseEntity.ok(accountdto);
	 }
	 
	 @PutMapping("/{id}/deposit")
	 public ResponseEntity<Accountdto> deposit(@PathVariable long id , @RequestBody Map<String  , Double> request){
		 
		 Double amount = request.get("amount");
		 
		Accountdto accountdto =  accountService.deposit(id, amount);
		 
		 return ResponseEntity.ok(accountdto);
	 }
	 
	 @PutMapping("/{id}/withdraw")
	 public ResponseEntity<Accountdto> withdraw(@PathVariable long id , @RequestBody Map<String , Double> request){
		   
		 Double amount = request.get("amount");
		 
		 Accountdto accountdto = accountService.withdraw(id, amount);
		 
		 return ResponseEntity.ok(accountdto);
	 }
	 
	 @GetMapping("/getAll")
	 public ResponseEntity<List<Accountdto>>getAllAccounts(){
		 
		List<Accountdto> accountdto = accountService.getAllAccounts();
		
		return ResponseEntity.ok(accountdto);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteAccount(@PathVariable long id){
		 
		 accountService.deleteAccount(id);
		 
		   return ResponseEntity.ok("Account Deleted Succesfully !");
	 }
	 
	 
}
