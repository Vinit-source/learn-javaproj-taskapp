/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

import java.util.List;

import com.fssa.learnJava.project.taskapp.dao.TaskDao;
import com.fssa.learnJava.project.taskapp.dao.exception.DaoException;

/**
 * @author VinitGore
 *
 */
public class TaskService {

	public boolean addTask(Task task) throws ServiceException {
		if (task.getTask() == null || "".equals(task.getTask())) {
			System.out.println("Task name not entered!");
			return false;
		}

		TaskDao taskDao = new TaskDao();
		
		// Business logic comes in the service layer
		task.setTaskStatus("PENDING");
		
		try {
		if (taskDao.createTask(task)) {
			System.out.println("Task successfully added!");
			return true;
		} else {
			System.out.println("Task not added");
			return false;
		}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public List<Task> getAllTasks() throws ServiceException {
		TaskDao taskDao = new TaskDao();
		
		try {
		List<Task> tasksFromDB = taskDao.getAllTasks();
		
		System.out.println(" Sr.No.  | Task Name                | Status           | Actions      ");
		for (Task task : tasksFromDB) {
			String formattedString = String.format("%-10d|%-26s|%-18s|", task.getId(), task.getTask(),
					task.getTaskStatus());
			System.out.println(formattedString);
		}
		return tasksFromDB;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
