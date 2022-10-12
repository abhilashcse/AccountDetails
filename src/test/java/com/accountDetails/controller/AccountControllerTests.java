package com.accountDetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.accountDetails.client.CustomerRegistrationMicroserviceClient;
import com.accountDetails.dto.CustomerProfileDTO;
import com.accountDetails.dto.User;
import com.accountDetails.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTests {
	
	@Autowired
	private CustomerRegistrationMicroserviceClient customerRegistrationMicroserviceClient;
	
	@Autowired
	private AccountController accountController;
	
	@Autowired
	private MockMvc mockMvc;
	
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
	
	@Test
	void editAccountDetailTest() throws Exception {
		User user = new User("Abhi123","Abhi@123");
		ResponseEntity<?> jwtResponse = customerRegistrationMicroserviceClient.generateToken(user);
		String stk=jwtResponse.getBody().toString();
		String[] toc = stk.split("=");
		String token = toc[1].substring(0,toc[1].length()-1);
		CustomerProfileDTO customerProfile = new CustomerProfileDTO("Abhilash", "Abhi@123", "xyz", "pqr", "india", "shyam123@gnail.com", "ALWPG5809L", "08-01-2000", "SAVING", "7091735618");
		assertThat(accountController.editAccountDetails(customerProfile, token)).isNotBlank();
	}
	
}
