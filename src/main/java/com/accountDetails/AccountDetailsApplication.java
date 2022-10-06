package com.accountDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDetailsApplication.class, args);
	}

}
