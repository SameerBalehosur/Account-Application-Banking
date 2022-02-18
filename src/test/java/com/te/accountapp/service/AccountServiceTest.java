package com.te.accountapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.te.accountapp.AccountApplication;
import com.te.accountapp.model.Account;
import com.te.accountapp.model.Account.accountStatus;
import com.te.accountapp.model.Account.gender;
import com.te.accountapp.repository.AccountRepo;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

	@InjectMocks
	private AccountServiceImpl accountServiceImpl;

	@Mock
	private AccountRepo accountRepo;

	@Test
	void addAccountTest() {
		Account account = new Account((long) 25, "mohan", gender.MALE, "bangalore", "virat", 6577.0,
				accountStatus.ACTIVE);
		Mockito.when(accountRepo.save(Mockito.any())).thenReturn(account);
		Account account2 = accountServiceImpl.addAccount(account);
		assertEquals(account.getAccountId(), account2.getAccountId());
	}

	@Test
	void updateAccountTest() {
		Account account2 = new Account((long) 25, "mohan", gender.MALE, "bangalore", "virat", 6577.0,
				accountStatus.ACTIVE);
		
		Mockito.when(accountRepo.save(Mockito.any())).thenReturn(account2);
		Account updatedAccount = accountServiceImpl.updateAccount(account2.getAccountId());
		updatedAccount.setAccountId(12l);
		updatedAccount.setAccountHolderName("vk");
		updatedAccount.setAccountStatus(accountStatus.ACTIVE);
		updatedAccount.setAddress("bangalore");
		updatedAccount.setCurrentAmount(6578.98);
		updatedAccount.setGender(gender.MALE);
		updatedAccount.setNominee("ABD");
		assertEquals(account2, updatedAccount);

		
//		Mockito.when(accountServiceImpl.updateAccount(updatedAccount.getAccountId())).thenReturn(updatedAccount);
//		assertEquals(account2.getAccountId(), updatedAccount.getAccountId());
	}

}
