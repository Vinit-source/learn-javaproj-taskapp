/**
 * 
 */
package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.LoginService;

/**
 * @author VinitGore
 *
 */
public class TestRegisterFeature {

	/**
	 * @param args
	 * @throws Exception
	 * 
	 */
	@Test
	public void testRegisterFeature() throws Exception {
		// TODO Auto-generated method stub
		LoginService login = new LoginService();

		// Initialized objects
//		Scanner sc = new Scanner(System.in);
//		User user = new User();
//
//		// Get Input User registration details using Scanner
//		System.out.println("Enter username");
//		user.setName(sc.nextLine());
//
//		System.out.println("Enter email");
//		user.setEmail(sc.nextLine());
//
//		System.out.println("Enter password");
//		user.setPassword(sc.nextLine());
		
		User user = new User();
		user.setName("Vinit");
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		assertFalse(login.registerUser(user));

	}

}
