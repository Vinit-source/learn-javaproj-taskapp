/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author Vinit Gore
 *
 **/
public class TestAddTaskFeature {
	@Test
	public void testAddTaskSuccess() {
		try {
			UserService userService = new UserService();
			TaskService addTaskService = new TaskService();

			User user = new User();

			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("1234567890");

			// To be used when tasks are filtered w.r.t. user.
			User loggedInUser = userService.login(user);
			if (loggedInUser != null) {
				Task task = new Task();
				task.setTask("Install MySQL Workbench");
				task.setCreatedBy(loggedInUser);
				boolean status = addTaskService.addTask(task);
				assertTrue(status);
			} else {
				fail("User login failed.");
			}
		} catch (ServiceException e) {
//			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAddEmptyTask() throws Exception {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();

		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		// To be used when tasks are filtered w.r.t. user.
		try {
			User loggedInUser = loginService.login(user);
			if (loggedInUser != null) {
				Task task = new Task();
				task.setTask("");
				addTaskService.addTask(task);
			} else {
				fail("User Login failed.");
			}
		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals(e.getMessage(), "Invalid task input entered.");
		}

	}

	@Test
	public void testAddNullTask() throws Exception {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();

		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		// To be used when tasks are filtered w.r.t. user.
		try {
			User loggedInUser = loginService.login(user);
			if (loggedInUser != null) {
				Task task = null;
				addTaskService.addTask(task);
			} else {
				fail("User Login failed.");
			}
		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals(e.getMessage(), "Task data not initialized.");
		}

	}

}
