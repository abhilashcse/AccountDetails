package com.accountDetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountDetails.dto.CustomerProfileDTO;
import com.accountDetails.model.Account;
import com.accountDetails.repository.AccountRepo;

@Service
public class AccountService {
	@Autowired
	AccountRepo accountRepo;
	
	public String editAccountDtails(CustomerProfileDTO customerProfile) {
		Account account = accountRepo.findByUsername(customerProfile.getUsername());
		int id= account.getId();
		Account newCustomer = new Account(id, customerProfile.getName(), customerProfile.getUsername(), customerProfile.getPassword(), customerProfile.getAddress(), customerProfile.getState(),
				customerProfile.getCountry(), customerProfile.getEmailAddress(), customerProfile.getPan(), customerProfile.getDateOfBirth(), customerProfile.getAccountType(), customerProfile.getMobileNo());
	   accountRepo.save(newCustomer);
	   return "updated";
		
	}
	
	public Account accountDetails(String userName) {
		return accountRepo.findByUsername(userName);
	}
	
}
