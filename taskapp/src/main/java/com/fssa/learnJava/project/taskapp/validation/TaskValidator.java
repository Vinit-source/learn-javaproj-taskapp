package com.fssa.learnJava.project.taskapp.validation;

import java.time.LocalDateTime;

import com.fssa.learnJava.project.taskapp.model.Task;

public class TaskValidator {

	public boolean validateNewTask(Task task) throws InvalidTaskException {
		if (task == null) {
			throw new InvalidTaskException("Task is null");
		} else {
			return validateTaskDesc(task.getTask()) && validateTaskStatus(task.getTaskStatus());
		}
	}

	public boolean validateTaskDesc(String taskDesc) throws InvalidTaskException {
		if (taskDesc.isEmpty()) {
			throw new InvalidTaskException("Task is empty");
		}
		return true;
	}

	public boolean validateTaskStatus(String taskStatus) throws InvalidTaskException {
		if (!("PENDING".equals(taskStatus) || "COMPLETED".equals(taskStatus))) {
			throw new InvalidTaskException("TaskStatus should be either 'PENDING' or 'COMPLETED'");
		}
		return true;
	}

	public boolean validateCompletedAt(Task task) throws InvalidTaskException {
		if ("COMPLETED".equals(task.getTaskStatus()) && task.getCompletedAt() == null)
			throw new InvalidTaskException("Task Completed time cannot be null for COMPLETED tasks.");
		else if (!(task.getCompletedAt() == null) && LocalDateTime.now().isBefore(task.getCompletedAt()))
			throw new InvalidTaskException("Task cannot be completed in future.");
		return true;
	}
}
