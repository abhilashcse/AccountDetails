package com.accountDetails.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.accountDetails.model.JWTResponse;


@FeignClient(name="CustomerRegistrationService", url = "http://localhost:8084/")
public interface CustomerRegistrationMicroserviceClient {

	@PostMapping("/validate")
	public String validateToken(@RequestBody JWTResponse response);
}

