package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.UserService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author BharathwajSoundarara
 *
 */
public class TestLoginFeature {
	@Test
	public void testLoginFeature() throws Exception{
		UserService loginService = new UserService();

		User user = new User();
		user.setName("VinitGore");
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");
		
		
		try {
		String result = loginService.login(user);
		assertEquals(result, "SUCCESSFUL");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to login.");
			
		}
	
	}

}