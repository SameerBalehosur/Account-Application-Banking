package com.te.accountapp.service;

import java.util.List;

import com.te.accountapp.model.Account;

public interface AccountService {
	
	public Account addAccount(Account account);

	public Account updateAccount(Long accountId);

	public void deleteAccount(Long accountId);
	
	public String addAmount(Long accountId,double amount);
	
	public String withdrawAmount(Long accountId,double amount);
	
	public List<Account> findAllAccounts(); 
	
}
