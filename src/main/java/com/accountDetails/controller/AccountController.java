package com.accountDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountDetails.client.CustomerRegistrationMicroserviceClient;
import com.accountDetails.dto.CustomerProfileDTO;
import com.accountDetails.model.Account;
import com.accountDetails.model.JWTResponse;
import com.accountDetails.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	CustomerRegistrationMicroserviceClient customerRegistrationMicroserviceClient;
	
	@PutMapping("/editDetails")
	public String editAccountDetails(@RequestBody CustomerProfileDTO customerProfileDTO, @RequestHeader(name="Authorization") String token) {
		JWTResponse jwtResponse = new JWTResponse(token);
		String res = customerRegistrationMicroserviceClient.validateToken(jwtResponse);
		String [] response = res.split(" ");
		if("true".equals(response[1])) {
			return accountService.editAccountDtails(customerProfileDTO,response[0]);
		}
		else {
			return "not allowed";
		}
	}
	
	@GetMapping("/accountDetails")
	public Account accountDetails(@RequestHeader(name="Authorization") String token) {
		JWTResponse jwtResponse = new JWTResponse(token);
		String res = customerRegistrationMicroserviceClient.validateToken(jwtResponse);
		String [] response = res.split(" ");
		if("true".equals(response[1])) {
			return accountService.accountDetails(response[0]);
		}
		else {
			return null;
		}
	}

}
