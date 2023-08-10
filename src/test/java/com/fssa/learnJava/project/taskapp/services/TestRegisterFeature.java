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
			user.setEmail("vinit.gore" + System.nanoTime() + "@example.com");
			user.setPassword("Passw0rd!" + System.nanoTime());

			assertEquals("Registration Successful", login.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Registration Unsuccessful");
		}
	}

	@Test
	public void testAlreadyRegisteredUser() {
		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("Passw0rd!");

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
			user.setEmail("vinit.gore" + System.nanoTime() + "@example.com");
			user.setPassword("Passw0rd!" + System.nanoTime());
			login.registerUser(user);
			fail("Empty name test failed.");
		} catch (ServiceException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
	}

	@Test
	public void testEmptyEmailId() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("");
			user.setPassword("Passw0rd!" + System.nanoTime());
			login.registerUser(user);
			fail("Empty email test failed.");
		} catch (ServiceException e) {
			assertEquals("Invalid email.", e.getMessage());
		}
	}

	@Test
	public void testInvalidEmailId() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gorectr.freshworks.com");
			user.setPassword("Passw0rd!" + System.nanoTime());
			login.registerUser(user);
			fail("Invalid email test failed.");
		} catch (ServiceException e) {
			assertEquals("Invalid email.", e.getMessage());
		}
	}

	@Test
	public void testValidateEmptyPassword() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore" + System.nanoTime() + "@example.com");
			user.setPassword("");
			login.registerUser(user);
			fail("Empty password test failed.");
		} catch (ServiceException e) {
			assertEquals("Invalid password.", e.getMessage());
		}
	}

	@Test
	public void testValidatePasswordLessThan8Chars() {

		try {
			UserService login = new UserService();

			User user = new User();
			user.setName("Vinit");
			user.setEmail("vinit.gore" + System.nanoTime() + "@example.com");
			user.setPassword("Psw0rd!");
			login.registerUser(user);
			fail("Password less than 8 chars test failed.");
		} catch (ServiceException e) {
			assertEquals("Invalid password.", e.getMessage());
		}
	}

}
