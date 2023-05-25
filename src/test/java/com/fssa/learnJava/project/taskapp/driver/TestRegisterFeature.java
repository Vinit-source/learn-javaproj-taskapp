/**
 * 
 */
package com.fssa.learnJava.project.taskapp.driver;

import java.util.Scanner;

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
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LoginService login = new LoginService();

		// Initialized objects
		Scanner sc = new Scanner(System.in);
		User user = new User();

		// Get Input User registration details using Scanner
		System.out.println("Enter username");
		user.setName(sc.nextLine());
		
		System.out.println("Enter email");
		user.setEmail(sc.nextLine());
		
		System.out.println("Enter password");
		user.setPassword(sc.nextLine());
		
		
		System.out.println(login.registerUser(user));
		
	}

}
