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
			TaskService addTaskService = new TaskService();

			User user = new User();
			user.setId(101);
			user.setEmail("vinit.gore@ctr.freshworks.com");
			user.setPassword("Passw0rd!");

			// To be used when tasks are filtered w.r.t. user.
			Task task = new Task();
			task.setTask("Install MySQL Workbench");
			task.setCreatedBy(user);
			boolean status = addTaskService.addTask(task);
			assertTrue(status);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAddEmptyTask() {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();
		user.setId(101);
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("Passw0rd!");

		// To be used when tasks are filtered w.r.t. user.
		try {
			User loggedInUser = loginService.login(user);
			if (loggedInUser != null) {
				Task task = new Task();
				task.setTask("");
				task.setCreatedBy(user);
				addTaskService.addTask(task);
			} else {
				fail("User Login failed.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			assertEquals("Task is empty", e.getMessage());
		}

	}

	@Test
	public void testAddNullTask() throws Exception {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();
		user.setId(101);
		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("Passw0rd!");

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
			e.printStackTrace();
			assertEquals("Task is null", e.getMessage());
		}

	}

}
