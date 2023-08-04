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
public class TestEditTaskFeature {

	@Test
	public void testEditTasksDescriptionUpdateSuccess() {
		try {
			TaskService taskService = new TaskService();
			List<Task> tasksFromDB = taskService.getAllTasks();

			Task task = new Task();
			task = tasksFromDB.get(tasksFromDB.size() - 1);
			task.setTask("Some different task");

			assertTrue(taskService.updateTask(task));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	// -------------------------//

	@Test
	public void testEditTasksStatusUpdateSuccess() {
		try {
			TaskService taskService = new TaskService();

			List<Task> tasksFromDB = taskService.getAllTasks();

			Task task = new Task();
			task = tasksFromDB.get(tasksFromDB.size() - 1);
			task.setTaskStatus("COMPLETED");
			task.setCompletedAt(LocalDateTime.now());
			assertTrue(taskService.updateTask(task));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testEditTasksStatusUpdateWithoutCompletedTime() {
		try {
			TaskService taskService = new TaskService();
			Task taskToAdd = new Task();
			taskToAdd.setTask("Running 'testEditTasksStatusUpdateWithoutCompletedTime'");
			taskService.addTask(taskToAdd);

			List<Task> tasksFromDB = taskService.getAllTasks();

			Task taskFromDB = new Task();
			taskFromDB = tasksFromDB.get(tasksFromDB.size() - 1);
			taskFromDB.setTaskStatus("COMPLETED");
			taskService.updateTask(taskFromDB);
			fail();
		} catch (ServiceException e) {
//			e.printStackTrace();
			assertEquals("Task Completed time cannot be null for COMPLETED tasks.", e.getMessage());
		}
	}
}
