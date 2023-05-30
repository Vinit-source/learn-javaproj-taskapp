/**
 * 
 */
package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.LoginService;
import com.fssa.learnJava.project.taskapp.services.TaskService;

/**
 * @author VinitGore
 *
 */
class TestListTasksFeature {

	@Test
	public void testListTasksFeature() throws Exception {
		TaskService taskService = new TaskService();
		
		List<Task> testTasks = taskService.getAllTasks();
		assertTrue(testTasks.size() > 0);
	}
}
