package com.te.accountapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.accountapp.model.Account;
import com.te.accountapp.service.AccountService;

import antlr.collections.List;

@RestController
public class AccountController {
	@Autowired
	private AccountService service;

	@PostMapping(value = "/add")
	public ResponseEntity<?> addAccount(@RequestBody @Valid Account account) {
		service.addAccount(account);
		return new ResponseEntity<>("Account added successfully", HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> updateAccount(Long accountId, @RequestBody Account account) {
		service.updateAccount(accountId, account);
		return new ResponseEntity("Account update", HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteAccount(Long accountId) {
		service.deleteAccount(accountId);
		return new ResponseEntity("Account Disabled temporarly",HttpStatus.OK);
	}

	@PostMapping(value = "/addmoney")
	public ResponseEntity<?> addAmount( long accountId,  double amount) {
		Account account=new Account();
		account.getAccountId();
		service.addAmount(accountId, amount);
		return new ResponseEntity("Amount added", HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/withdraw")
	public ResponseEntity<?> withdrawAmount(long accountId,double amount) {
		service.withdrawAmount(accountId, amount);
		return new ResponseEntity("Withdraw your money", HttpStatus.OK);
	}


	@GetMapping(value = "/findall") 
	public ResponseEntity<?> findAll() {
		java.util.List<Account> list=service.findAllAccounts(); 
		return new ResponseEntity(list, HttpStatus.OK); }


}
