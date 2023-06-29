/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void testAddTaskSuccess() throws Exception {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();
		// System.out.println("Enter user name:");
		// String userName = scanner.nextLine();
		//
		// System.out.println("Enter Password: ");
		// String userPassword = scanner.nextLine();

		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		// To be used when tasks are filtered w.r.t. user.
		String loggedInUser = loginService.login(user);

		Task task = new Task();
//		System.out.println("Task Name: ");
//		String taskName = scanner.nextLine();
//		task.setTask(taskName);
		task.setTask("Install MySQL Workbench");

		assertTrue(addTaskService.addTask(task));
	}

	@Test
	public void testAddEmptyTask() throws Exception {
		UserService loginService = new UserService();
		TaskService addTaskService = new TaskService();

		User user = new User();
		// System.out.println("Enter user name:");
		// String userName = scanner.nextLine();
		//
		// System.out.println("Enter Password: ");
		// String userPassword = scanner.nextLine();

		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		// To be used when tasks are filtered w.r.t. user.
		String loggedInUser = loginService.login(user);

		Task task = new Task();
//		System.out.println("Task Name: ");
//		String taskName = scanner.nextLine();
//		task.setTask(taskName);
		task.setTask("");

		try {
			addTaskService.addTask(task);
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
		// System.out.println("Enter user name:");
		// String userName = scanner.nextLine();
		//
		// System.out.println("Enter Password: ");
		// String userPassword = scanner.nextLine();

		user.setEmail("vinit.gore@ctr.freshworks.com");
		user.setPassword("1234567890");

		// To be used when tasks are filtered w.r.t. user.
		String loggedInUser = loginService.login(user);

		Task task = null;

		try {
			addTaskService.addTask(task);
		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals(e.getMessage(), "Task data not initialized.");
		}

	}
}
