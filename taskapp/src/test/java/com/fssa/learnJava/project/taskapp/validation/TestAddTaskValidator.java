/**
 * 
 */
package com.fssa.learnJava.project.taskapp.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * @author Vinit Gore
 *
 **/
public class TestAddTaskValidator {
	TaskValidator taskValidator = new TaskValidator();
	
	@Test
	public void testTaskValidatorSuccess() {
		Task task = new Task();
		task.setTask("Demo task.");
		task.setTaskStatus("PENDING");
		try {			
			taskValidator.validateNewTask(task);
		} catch (InvalidTaskException e) {
			fail();
		}
	}
	
	@Test
	public void testTaskValidatorOnTaskNull() {
		Task task = null;
		try {			
			taskValidator.validateNewTask(task);
		} catch (InvalidTaskException e) {
			assertEquals("Task is null", e.getMessage());
		}
	}
	
	@Test
	public void testTaskValidatorOnTaskEmpty() {
		Task task = new Task();
		task.setTask("");
		task.setTaskStatus("PENDING");
		try {			
			taskValidator.validateNewTask(task);
		} catch (InvalidTaskException e) {
			assertEquals("Task is empty", e.getMessage());
		}
	}
	
	@Test
	public void testTaskValidatorOnInvalidTaskStatus() {
		Task task = new Task();
		task.setTask("Demo task.");
		task.setTaskStatus("NOT PENDING");
		try {			
			taskValidator.validateNewTask(task);
		} catch (InvalidTaskException e) {
			assertEquals("TaskStatus should be either 'PENDING' or 'COMPLETED'", e.getMessage());
		}
	}
	
}
