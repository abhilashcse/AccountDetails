package com.accountDetails.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JWTResponseTest {

	private JWTResponse jwtResponse1;
	 private JWTResponse jwtResponse2;
	 
	    @BeforeEach
	    void setUp() throws Exception {

	    	jwtResponse1 = new JWTResponse();
	    	jwtResponse2 = new JWTResponse("its Token");
	    }

	    @Test
	    void testPensionerBean() {
	        final BeanTester beanTester = new BeanTester();
	        beanTester.getFactoryCollection();
	        beanTester.testBean(JWTResponse.class);
	    }
}
