/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;
import com.fssa.learnJava.project.taskapp.validation.InvalidTaskException;
import com.fssa.learnJava.project.taskapp.validation.TaskValidator;

import java.time.LocalDateTime;
import java.util.List;

import com.fssa.learnJava.project.taskapp.dao.TaskDao;
import com.fssa.learnJava.project.taskapp.dao.exception.DaoException;

/**
 * @author VinitGore
 *
 */
public class TaskService {

	TaskValidator taskValidator;
	TaskDao taskDao;

	public TaskService() {
		this.taskValidator = new TaskValidator();
		this.taskDao = new TaskDao();
	}

	public boolean addTask(Task task) throws ServiceException {
		try {
			// Business logic comes in the service layer
			task.setTaskStatus("PENDING");

			if (taskValidator.validateNewTask(task)) {

				if (taskDao.createTask(task)) {
					System.out.println("Task successfully added!");
					return true;
				} else {
					System.out.println("Task not added");
					return false;
				}
			}
		} catch (InvalidTaskException e) {
			throw new ServiceException("Invalid task input entered.", e);
		} catch (DaoException e) {
			throw new ServiceException(e);
		} catch (NullPointerException e) {
			throw new ServiceException("Task data not initialized.", e);
		}
		return false;
	}

	public List<Task> getAllTasks() throws ServiceException {
		List<Task> tasksFromDB;
		try {
			tasksFromDB = taskDao.getAllTasks();
			System.out.format("%-8s | %-25s | %-15s | %-10s%n", "Sr.No.", "Task Name", "Status", "Actions");
			for (Task task : tasksFromDB) {
				System.out.format("%-8d | %-25s | %-15s | %s%n", task.getId(), task.getTask(), task.getTaskStatus(),
						"");
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return tasksFromDB;
	}

	public boolean editTask(Task task) throws ServiceException {
		boolean operationStatus = false;
		try {
			if (taskValidator.validateTaskStatus(task.getTaskStatus()) && taskValidator.validateCompletedAt(task)) {
				operationStatus = taskDao.updateTask(task);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		} catch (InvalidTaskException e) {
			throw new ServiceException(e);
		}
		System.out.println("The task with id " + task.getId() + " was edited successfully!");
		return operationStatus;

	}

}
