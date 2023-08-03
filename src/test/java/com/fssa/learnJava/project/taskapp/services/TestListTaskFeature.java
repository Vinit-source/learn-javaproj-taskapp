/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * @author Vinit Gore
 *
 **/
public class TestListTaskFeature {

	@Test
	public void testListTasksSuccess() {
		try {
			TaskService taskService = new TaskService();
			List<Task> testTasks = taskService.getAllTasks();
			System.out.println(testTasks);
			assertTrue(testTasks.size() > 0);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
