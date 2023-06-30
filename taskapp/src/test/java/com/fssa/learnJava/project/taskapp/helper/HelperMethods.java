/**
 * 
 */
package com.fssa.learnJava.project.taskapp.helper;

import static org.junit.jupiter.api.Assertions.fail;

import com.fssa.learnJava.project.taskapp.services.UserService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author Vinit Gore
 *
 **/
public class HelperMethods {
	public static void logoutHelper() {
		UserService userService;
		try {
			userService = new UserService();
			userService.logout();
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Failed to logout.");
		}
	}
}
