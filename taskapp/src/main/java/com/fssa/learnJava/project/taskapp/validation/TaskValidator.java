package com.fssa.learnJava.project.taskapp.validation;

import com.fssa.learnJava.project.taskapp.model.Task;

public class TaskValidator {

	public boolean validateNewTask(Task task) throws InvalidTaskException {
		if (task == null) {
			throw new InvalidTaskException("Problem in creating new task");
		} else if (task.getTask().isEmpty()) {
			throw new InvalidTaskException("Task is empty");
		} else if ("PENDING".equals(task.getTaskStatus()) && "COMPLETED".equals(task.getTaskStatus())) {
			throw new InvalidTaskException("TaskStatus should be either 'PENDING' or 'COMPLETED'");
		} else {
			return true;
		}

	}
}
