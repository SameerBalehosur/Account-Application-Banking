package com.te.accountapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.te.accountapp.custome.exception.BusinessException;
import com.te.accountapp.model.Account;
import com.te.accountapp.model.Account.accountStatus;
import com.te.accountapp.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo repo;
	
	Account account;

	@Override
	public Account addAccount(Account account) {
		if (account.getAccountHolderName().isEmpty() || account.getCurrentAmount() == 0) {
			throw new BusinessException("601", "Something went wrong !");
		}
		try {
			return repo.save(account);
		} catch (Exception e) {
			throw new BusinessException("602", "Enter  the name" + e.getMessage());
		}
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Account updateAccount(Long accountId) {
		if (account.getAccountId() == 0) {
			throw new BusinessException("603", "please enter valid ID !");
		}try {
			Account accounts = repo.findByAccountId(accountId);
			accounts.setAddress(account.getAddress());
			return repo.save(accounts);
		} catch (Exception e) {
			throw new BusinessException("604", "Given employee ID is not present " + e.getMessage());
		}
	}

	@Override
	public void deleteAccount(Long accountId) {
		Account account=new Account();
		if(accountId==account.getAccountId()) {
			throw new BusinessException("605","Something wentss wrong !");
		}
		try {
			Account findByAccountId = repo.findByAccountId(accountId);
			findByAccountId.setAccountStatus(accountStatus.INACTIVE);
			repo.save(findByAccountId);
		} catch (Exception e) {
			throw new BusinessException("606","Enter the Correct ID"+e.getMessage());
		}
	}

	@Override
	public String withdrawAmount(Long accountId, double amount) {
		if(account.getAccountId()!=accountId) {
			if(amount>account.getCurrentAmount()) {
				throw new BusinessException("607","Something went wrong !");
			}
		}
		try {
			Account currentAmount = repo.findByAccountId(accountId);
			double currentAmount2 = currentAmount.getCurrentAmount();
			if (amount < currentAmount2) {
				currentAmount2 = currentAmount2 - amount;
				currentAmount.setCurrentAmount(currentAmount2);
				repo.save(currentAmount);
				return "Withdraw Success";
			}
			return null;
		} catch (Exception e) {
			throw new BusinessException("608","Either Account Id or Amount is Wrong");
		}
	}

	@Override
	public String addAmount(Long accountId, double amount) {
		if(account.getAccountId()!=accountId) {
			if(amount==0) {
				throw new BusinessException("609","Something went wrong !");
			}
		}
		try {
			Account account2 = repo.findByAccountId(accountId);
			double currentAmount2 = account2.getCurrentAmount();
			currentAmount2 = currentAmount2 + amount;
			account2.setCurrentAmount(currentAmount2);
			repo.save(account2);
			return "Added";
		} catch (Exception e) {
			throw new BusinessException("609","Enter the correct amount or ID is wrong");
		}

	}

	@SuppressWarnings("null")
	@Override
	public List<Account> findAllAccounts() {
		List<Account> findAll = null;
		if(findAll.isEmpty()) {
			throw new BusinessException("610","Something went wrong !");
		}
		try {
			findAll = repo.findAll();
		} catch (Exception e) {
			throw new BusinessException("611","The list is Empty, Please add data to list first");
		}
		return findAll;
	}

}
