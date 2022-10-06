package com.accountDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountDetails.client.AuthorizationMicroserviceClient;
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
	AuthorizationMicroserviceClient authorizationMicroserviceClient;
	
	@PutMapping("/editDetails")
	public String editAccountDetails(@RequestBody CustomerProfileDTO customerProfileDTO, @RequestHeader(name="Authorization") String token) {
		JWTResponse jwtResponse = new JWTResponse(token);
		String res = authorizationMicroserviceClient.validateToken(jwtResponse);
		String [] response = res.split(" ");
		if(response[1].equals("true")) {
			return accountService.editAccountDtails(customerProfileDTO);
		}
		else {
			return "not allowed";
		}
	}
	
	@GetMapping("/accountDetails")
	public Account accountDetails(@RequestHeader(name="Authorization") String token) {
		JWTResponse jwtResponse = new JWTResponse(token);
		String res = authorizationMicroserviceClient.validateToken(jwtResponse);
		String [] response = res.split(" ");
		if(response[1].equals("true")) {
			return accountService.accountDetails(response[0]);
		}
		else {
			return null;
		}
	}

}
