package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.LoginService;

/**
 * @author BharathwajSoundarara
 *
 */
public class TestLoginFeature {
	@Test
	public void testLoginFeature() throws Exception{
		LoginService loginService = new LoginService();
		
//		Scanner scanner = new Scanner(System.in);
//		
//		User user = new User();
//		System.out.println("Enter user name:");
//		String userName = scanner.nextLine();
//		
//		System.out.println("Enter Password: ");
//		String userPassword = scanner.nextLine();
//		
//		user.setName(userName);
//		user.setPassword(userPassword);

		User user = new User();
		user.setName("VinitGore");
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");
		
		
		
		User loggedInUser = loginService.login(user);
		
		assertEquals(user.getName(), loggedInUser.getName());
		
//		scanner.close();
	}

}