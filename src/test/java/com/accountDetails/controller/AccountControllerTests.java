package com.accountDetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.accountDetails.client.CustomerRegistrationMicroserviceClient;
import com.accountDetails.dto.User;
import com.accountDetails.model.Account;

@SpringBootTest
class AccountControllerTests {
	
	@Autowired
	private CustomerRegistrationMicroserviceClient customerRegistrationMicroserviceClient;
	
	@Autowired
	private AccountController accountController;
	
	@Test
	void accountDetailsTest() throws Exception {
		User user = new User("Abhi123","Abhi@123");
		ResponseEntity<?> jwtResponse = customerRegistrationMicroserviceClient.generateToken(user);
		String stk=jwtResponse.getBody().toString();
		String[] toc = stk.split("=");
		String token = toc[1].substring(0,toc[1].length()-1);
		Account respose = accountController.accountDetails(token);
		assertThat(respose).isInstanceOf(Account.class);
	}

}
