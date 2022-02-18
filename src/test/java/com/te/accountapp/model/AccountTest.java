package com.te.accountapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.accountapp.model.Account.accountStatus;
import com.te.accountapp.model.Account.gender;
class AccountTest {
	ObjectMapper mapper=new ObjectMapper();
	String json="{\"accountId\":1,\"accountHolderName\":\"Sameer\",\"gender\":\"MALE\",\"address\":\"bANGALORE\",\"nominee\":\"Boij\",\"currentAmount\":6788.98,\"accountStatus\":\"ACTIVE\"}";

	@Test
	void serializeTest() throws JsonProcessingException {
		//This is to get JSON Values
		/*
		 * Account account=new Account(1l, "Sameer", gender.MALE, "bANGALORE", "Boij",
		 * 6788.98, accountStatus.ACTIVE); String writeValueAsString =
		 * mapper.writeValueAsString(account); System.out.println(writeValueAsString);
		 */
		Account readValue = mapper.readValue(json, Account.class);
		String writeValueAsString = mapper.writeValueAsString(readValue);
		assertEquals(json, writeValueAsString);
	}
	@Test
	void deserializeTest() throws JsonMappingException, JsonProcessingException {
		Account readValue = mapper.readValue(json, Account.class);
		assertEquals(1, readValue.getAccountId());

	}
}
