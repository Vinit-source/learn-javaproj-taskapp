/**
 * 
 */
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
public class TestRegisterFeature {

	@Test
	public void testNewRegisteringUser() {
		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore" + Math.random() + "@ctr.freshworks.com");
			user.setPassword("1234567890");

			assertEquals("Registration Successful", login.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			assertEquals("Invalid User", e.getMessage());
		}
	}

	@Test
	public void testAlreadyRegisteredUser() {
		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("1234567890");

			assertEquals("Email id vinit.gore@ctr.freshworks.com is already registered", login.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception while trying to register.");
		}
	}

	@Test
	public void testEmptyName() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("");
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("1234567890");
			login.registerUser(user);
		} catch (ServiceException e) {
			assertEquals("Invalid User", e.getMessage());
		}
	}

	@Test
	public void testEmptyEmailId() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("");
			user.setPassword("1234567890");
			login.registerUser(user);
		} catch (ServiceException e) {
			assertEquals("Invalid User", e.getMessage());
		}
	}

	@Test
	public void testInvalidEmailId() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gorectr.freshworks.com");
			user.setPassword("1234567890");
			login.registerUser(user);
		} catch (ServiceException e) {
			assertEquals("Invalid User", e.getMessage());
		}
	}

	@Test
	public void testValidateEmptyPassword() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("");
			login.registerUser(user);
		} catch (ServiceException e) {
			assertEquals("Invalid User", e.getMessage());
		}
	}

	@Test
	public void testValidatePasswordLessThan8Chars() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("1234567");
			login.registerUser(user);
		} catch (ServiceException e) {
			assertEquals("Invalid User", e.getMessage());
		}
	}

}
