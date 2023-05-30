/**
 * 
 */
package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.dao.UserDao;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.TaskService;
import com.fssa.learnJava.project.taskapp.services.LoginService;
import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * @author VinitGore
 *
 */
class TestAddTaskFeature {

	public void testAddTaskFeature(String[] args) throws Exception {
		LoginService loginService = new LoginService();
		TaskService addTaskService = new TaskService();

		Scanner scanner = new Scanner(System.in);

		User user = new User();
		// System.out.println("Enter user name:");
		// String userName = scanner.nextLine();
		//
		// System.out.println("Enter Password: ");
		// String userPassword = scanner.nextLine();

		user.setName("Vinit");
		user.setPassword("123456789");

		// To be used when tasks are filtered w.r.t. user.
		User loggedInUser = loginService.login(user);

		Task task = new Task();
		System.out.println("Task Name: ");
		String taskName = scanner.nextLine();
		task.setTask(taskName);

		assertTrue(addTaskService.addTask(task));

		scanner.close();
	}
}
