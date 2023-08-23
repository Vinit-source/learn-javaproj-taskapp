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
	public void testLoginSuccess() {
		try {
			UserService loginService = new UserService();

			User user = new User();
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("Passw0rd!");

			assertTrue(loginService.login(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to test loginSuccess.");
		}

	}

	@Test
	public void testEmptyEmailId() {

		try {
			UserService loginService = new UserService();

			User user = new User();
			user.setEmail("");
			user.setPassword("Passw0rd!");
			loginService.login(user);
		} catch (ServiceException e) {
			assertEquals("Invalid email.", e.getMessage());
		}
	}

	@Test
	public void testEmptyPassword() {

		try {
			UserService loginService = new UserService();

			User user = new User();
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("");
			loginService.login(user);
		} catch (ServiceException e) {
			assertEquals("Invalid password.", e.getMessage());
		}
	}

	@Test
	public void testLoginEmailNotFound() {
		try {
			UserService loginService = new UserService();

			User user = new User();
			user.setEmail("anonymous@example.com");
			user.setPassword("Passw0rd!");

			assertFalse(loginService.login(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			assertEquals("User not found.", e.getMessage());
		}

	}

	@Test
	public void testLoginPasswordDoesNotMatch() {

		try {
			UserService loginService = new UserService();

			User user = new User();
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("Passw0Rd!");

			assertFalse(loginService.login(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to test LoginPasswordDoesNotMatch.");
		}

	}

}