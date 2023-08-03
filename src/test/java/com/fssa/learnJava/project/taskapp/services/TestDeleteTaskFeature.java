/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author Vinit Gore
 *
 **/
public class TestDeleteTaskFeature {
	@Test
	public void testDeleteTaskSuccess() {
		try {
			TaskService taskService = new TaskService();

			List<Task> tasksFromDB = taskService.getAllTasks();
			// Find one PENDING task from DB
			Task pendingTask = null; // Initialize with a default value

			for (Task taskFromDB : tasksFromDB) {
				if ("PENDING".equals(taskFromDB.getTaskStatus())) {
					pendingTask = taskFromDB;
					break;
				}
			}

			if (pendingTask != null) {
				System.out.println(pendingTask.getId());
				assertTrue(taskService.deleteTask(pendingTask.getId()));
			} else {
				fail("No pending task found."); // Handle the case when no pending task is found
			}

		} catch (ServiceException e) {
//			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testTaskNotPresentInDB() {
		try {
			TaskService taskService = new TaskService();
			// Create a random task that should not be present in DB
			Task randomTask = new Task(); // Initialize with a default value
			randomTask.setId(9999999);

			taskService.deleteTask(randomTask.getId());
			fail();

		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals("Task with id 9999999 not present", e.getMessage());
		}
	}

	@Test
	public void testDeleteCompletedTask() {
		try {
			TaskService taskService = new TaskService();
			List<Task> tasksFromDB = taskService.getAllTasks();

			// Find one COMPLETED task from DB
			Task completedTask = null; // Initialize with a default value

			for (Task taskFromDB : tasksFromDB) {
				if ("COMPLETED".equals(taskFromDB.getTaskStatus())) {
					completedTask = taskFromDB;
					break;
				}
			}

			if (completedTask != null) {
				System.out.println(completedTask.getId());
				taskService.deleteTask(completedTask.getId());
				fail();
			} else {
				fail("No completed task found."); // Handle the case when no completed task is found
			}

		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals("Only PENDING tasks can be deleted.", e.getMessage());
		}
	}
}
