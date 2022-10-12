package com.accountDetails.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerProfileDTOTest {

	private CustomerProfileDTO customerProfile1;
	private CustomerProfileDTO customerProfile2;
	 
	    @BeforeEach
	    void setUp() throws Exception {

	    	customerProfile1 = new CustomerProfileDTO();
	    	customerProfile2 = new CustomerProfileDTO("Abhilash", "Abhi@123", "xyz", "pqr", "india", "shyam123@gnail.com", "ALWPG5809L", "08-01-2000", "SAVING", "7091735618");
	    }

	    @Test
	    void testPensionerBean() {
	        final BeanTester beanTester = new BeanTester();
	        beanTester.getFactoryCollection();
	        beanTester.testBean(CustomerProfileDTO.class);
	    }
}
