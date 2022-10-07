package com.accountDetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountDetails.dto.CustomerProfileDTO;
import com.accountDetails.model.Account;
import com.accountDetails.repository.AccountRepo;
import com.accountDetails.response.ErrorResponse;
import com.accountDetails.response.SuccessResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountService {
	@Autowired
	AccountRepo accountRepo;
	
	public String editAccountDtails(CustomerProfileDTO customerProfile,String username) {
		String response = null;
		Account account = accountRepo.findByUsername(username);
		List<ErrorResponse> errorList = validationError(customerProfile);
		if(!errorList.isEmpty()) {
			response = prepareErrorResponse(errorList);
			return response;
		}
		accountRepo.save(new Account(account.getId(),customerProfile.getName(), account.getUsername(), customerProfile.getPassword(), customerProfile.getAddress(), customerProfile.getState(),
			customerProfile.getCountry(), customerProfile.getEmailAddress(), customerProfile.getPan(), customerProfile.getDateOfBirth(), customerProfile.getAccountType(), customerProfile.getMobileNo()));
		return prepareSuccessResponse();
		
	}
	
	private String prepareSuccessResponse() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setMessage("Your Update has been successfully completed");
		ObjectMapper objectMapper = new ObjectMapper();
		String response = null;
		try {
			response = objectMapper.writeValueAsString(successResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
	
	
	private String prepareErrorResponse(List<ErrorResponse> listErrorResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		String response = null;
		try {
			response = objectMapper.writeValueAsString(listErrorResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	
	public List<ErrorResponse> validationError(CustomerProfileDTO customerProfile){
		List<ErrorResponse> errorList = new ArrayList<>();
		if(customerProfile.getName().isEmpty()) {
			errorList.add(new ErrorResponse("name", "Name is empty"));
		}
		
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{6,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(customerProfile.getPassword());

		if (!m.matches()) {
			errorList.add(new ErrorResponse("password","Password: Password should contain atleast 6 characters, uppercase, lowercase, special characters and numbers"));
		}
		
		String regex1 = "^(.+)@(.+).(.+)$";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(customerProfile.getEmailAddress());

		if (!m1.matches()) {
			errorList.add(new ErrorResponse("Email","Email: Enter valid email"));
		}
		
		String regex2 = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(customerProfile.getPan());

		if (!m2.matches()) {
			errorList.add(new ErrorResponse("pan","You entered wrong pan"));
		}
		
		Pattern p3 = Pattern.compile("[7-9][0-9]{9}");
		Matcher m3 = p3.matcher(customerProfile.getMobileNo());

		if (!m3.matches()) {
			errorList.add(new ErrorResponse("mobile","you entered wrong phone number"));
		}
		return errorList;
	}
	
	public Account accountDetails(String userName) {
		return accountRepo.findByUsername(userName);
	}
	
}
