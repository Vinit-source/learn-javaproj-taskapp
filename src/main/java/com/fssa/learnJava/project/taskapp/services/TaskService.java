/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;
import com.fssa.learnJava.project.taskapp.validation.InvalidTaskException;
import com.fssa.learnJava.project.taskapp.validation.TaskValidator;

import java.time.LocalDateTime;
import java.util.List;

import com.fssa.learnJava.project.taskapp.dao.TaskDAO;
import com.fssa.learnJava.project.taskapp.dao.exception.DAOException;

/**
 * @author VinitGore
 *
 */
public class TaskService {

	TaskValidator taskValidator;
	TaskDAO taskDAO;
	UserService userService;

	public TaskService() {
		this.taskValidator = new TaskValidator();
		this.taskDAO = new TaskDAO();
		this.userService = new UserService();
	}

	public boolean addTask(Task task) throws ServiceException {
		try {
			// Business rule: New task default status should be PENDING
			if (task != null)
				task.setTaskStatus("PENDING");
			// TODO: Add validation to check user null or not
			taskValidator.validateNewTask(task);
			taskDAO.createTask(task);
			return true;
		} catch (InvalidTaskException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Task> getAllTasks() throws ServiceException {
		List<Task> tasksFromDB;
		try {
			tasksFromDB = taskDAO.getAllTasks();
			System.out.format("%-8s | %-25s | %-15s | %-10s%n", "Sr.No.", "Task Name", "Status", "isDeleted?");
			for (Task task : tasksFromDB) {
				System.out.format("%-8d | %-25s | %-15s | %s%n", task.getId(), task.getTask(), task.getTaskStatus(),
						task.isDeleted());
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return tasksFromDB;
	}

	public boolean updateTask(Task task) throws ServiceException {
		boolean methodStatus = false;
		try {
			if (taskValidator.isValidTaskStatus(task.getTaskStatus()) && taskValidator.isValidCompletedAt(task)) {
				methodStatus = taskDAO.editTask(task);
			}
		} catch (DAOException | InvalidTaskException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		System.out.println("The task with id " + task.getId() + " was edited successfully!");
		return methodStatus;

	}

	public boolean deleteTask(int taskID) throws ServiceException {
		boolean methodStatus = false;
		try {
			List<Task> tasksFromDB = taskDAO.getAllTasks();

			Task foundTask = null;
			for (Task task : tasksFromDB) {
				if (task.getId() == taskID) {
					foundTask = task;
					break;
				}
			}

			if (foundTask == null)
				throw new ServiceException("Task with id " + taskID + " not present");

			if ("PENDING".equals(foundTask.getTaskStatus())) {
				methodStatus = taskDAO.removeTask(foundTask);
			} else {
				throw new ServiceException("Only PENDING tasks can be deleted.");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		System.out.println("The task with id " + taskID + " was deleted successfully!");
		return methodStatus;
	}

}
