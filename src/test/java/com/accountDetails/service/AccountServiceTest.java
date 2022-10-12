package com.accountDetails.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accountDetails.dto.CustomerProfileDTO;
import com.accountDetails.model.Account;

@SpringBootTest
class AccountServiceTest {

	@Autowired
	private AccountService accountService;
	
	@Test
	void accountDetailTest() {
		assertThat(accountService.accountDetails("Abhi123")).isInstanceOf(Account.class);
	}
	
	@Test
	void accounrDetailNegativeTest() {
		assertThat(accountService.accountDetails("admin")).isNull();
	}
	
	@Test
	void editAccountDetailTest() {
		CustomerProfileDTO customerProfile = new CustomerProfileDTO("Abhilash", "Abhi@123", "xyz", "pqr", "india", "shyam123@gnail.com", "ALWPG5809L", "08-01-2000", "SAVING", "7091735618");
		String response ="{\"message\":\"Your Update has been successfully completed\"}";
		assertEquals(accountService.editAccountDtails(customerProfile, "Abhi123"), response);
	}
}
