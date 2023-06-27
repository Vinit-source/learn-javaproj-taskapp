/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.dao.UserDao;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.TaskService;
import com.fssa.learnJava.project.taskapp.services.UserService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;
import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * @author VinitGore
 *
 */
class TestTaskService {

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
			e.printStackTrace();
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
			e.printStackTrace();
			assertEquals(e.getMessage(), "Invalid task input entered.");
		}

	}

	@Test
	public void testListTasksFeature() throws Exception {
		TaskService taskService = new TaskService();

		List<Task> testTasks = taskService.getAllTasks();
		System.out.println(testTasks);
		assertTrue(testTasks.size() > 0);
	}
}
