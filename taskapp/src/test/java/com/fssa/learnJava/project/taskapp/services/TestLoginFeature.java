package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.UserService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author VinitGore
 *
 */
public class TestLoginFeature {
	@Test
	public void testLoginSuccess() throws Exception{
		UserService loginService = new UserService();

		User user = new User();
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");
		
		
		try {
		String result = loginService.login(user);
		assertEquals(result, "SUCCESSFUL");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to test loginSuccess.");
			
		}
	
	}
	
	@Test
	public void testEmptyEmailId()  {
		
		try {
		UserService loginService = new UserService();

		User user = new User();
		user.setEmail("");
		user.setPassword("1234567890");
		loginService.login(user);
		} catch (ServiceException e) {
			assertEquals("Invalid input credentials. Please meet the required input formats.", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while trying to register.");
		}
	}
	
	@Test
	public void testEmptyPassword()  {
		
		try {
		UserService loginService = new UserService();

		User user = new User();
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("");
		loginService.login(user);
		} catch (ServiceException e) {
			assertEquals("Invalid input credentials. Please meet the required input formats.", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while trying to register.");
		}
	}
	
	@Test
	public void testLoginEmailNotFound() throws Exception{
		UserService loginService = new UserService();

		User user = new User();
		user.setEmail("anonymous@example.com");
		user.setPassword("1234567890");
		
		
		try {
		String result = loginService.login(user);
		assertEquals("Invalid Login Credentials", result);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to test LoginEmailNotFound.");
			
		}
	
	}
	
	@Test
	public void testLoginPasswordDoesNotMatch() throws Exception{
		UserService loginService = new UserService();

		User user = new User();
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("0000000000");
		
		
		try {
		String result = loginService.login(user);
		assertEquals("Invalid Login Credentials", result);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to test LoginPasswordDoesNotMatch.");
			
		}
	
	}

}