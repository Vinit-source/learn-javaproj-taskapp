package com.fssa.learnJava.project.taskapp.validation;

import java.time.LocalDateTime;
import java.util.List;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.validation.exception.InvalidTaskException;
import com.fssa.learnJava.project.taskapp.validation.exception.InvalidUserException;
import com.fssa.learnJava.project.taskapp.validation.exception.NoDataPresentException;

public class TaskValidator {

	public boolean validateNewTask(Task task) throws InvalidTaskException {
		if (task == null) {
			throw new InvalidTaskException("Task is null");
		} else {
			return isValidTaskDescription(task.getTask()) && isValidTaskStatus(task.getTaskStatus())
					&& isValidCreatedBy(task.getCreatedBy());
		}
	}

	public boolean isValidTaskDescription(String taskDesc) throws InvalidTaskException {
		if (taskDesc.isEmpty()) {
			throw new InvalidTaskException("Task is empty");
		}
		return true;
	}

	public boolean isValidTaskStatus(String taskStatus) throws InvalidTaskException {
		if (!("PENDING".equals(taskStatus) || "COMPLETED".equals(taskStatus))) {
			throw new InvalidTaskException("TaskStatus should be either 'PENDING' or 'COMPLETED'");
		}
		return true;
	}

	public boolean isValidCompletedAt(Task task) throws InvalidTaskException {
		if ("COMPLETED".equals(task.getTaskStatus()) && task.getCompletedAt() == null)
			throw new InvalidTaskException("Task Completed time cannot be null for COMPLETED tasks.");
		else if (task.getCompletedAt() != null && LocalDateTime.now().isBefore(task.getCompletedAt()))
			throw new InvalidTaskException("Task cannot be completed in future.");
		return true;
	}

	public boolean isValidCreatedBy(User user) throws InvalidTaskException {
		UserValidator userValidator = new UserValidator();
		if (user != null) {
			try {
				return userValidator.validateEmail(user.getEmail());
			} catch (InvalidUserException e) {
				throw new InvalidTaskException(e.getMessage(), e);
			}
		} else {
			throw new InvalidTaskException("Task creator field is null.");
		}
	}

	/**
	 * @param tasksFromDB
	 * @throws NoDataPresentException 
	 */
	public void validateTaskList(List<Task> tasksFromDB) throws NoDataPresentException {

		if (tasksFromDB.size() == 0) {
			throw new NoDataPresentException("No tasks present.");
		}
	}
}
