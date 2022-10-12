package com.accountDetails.model;

import org.meanbean.test.BeanTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {

	 private Account user1;
	 private Account user2;
	 
	    @BeforeEach
	    void setUp() throws Exception {

	        user1 = new Account();
	        user2 = new Account(1, "Abhilash", "admin", "Abhi@123", "xyz", "pqr", "india", "shyam123@gnail.com", "ALWPG5809L", "08-01-2000", "SAVING", "7091735618");
	    }

	    @Test
	    void testPensionerBean() {
	        final BeanTester beanTester = new BeanTester();
	        beanTester.getFactoryCollection();
	        beanTester.testBean(Account.class);
	    }
}
