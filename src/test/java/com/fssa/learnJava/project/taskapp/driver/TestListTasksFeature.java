/**
 * 
 */
package com.fssa.learnJava.project.taskapp.driver;

import static org.junit.jupiter.api.Assertions.*;

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
	public static void main(String[] args) throws Exception {
		TaskService TaskService = new TaskService();

		assertTrue(TaskService.getAllTasks());
	}
}
