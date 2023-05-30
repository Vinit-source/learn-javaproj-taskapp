/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import com.fssa.learnJava.project.taskapp.model.Task;

import java.util.List;

import com.fssa.learnJava.project.taskapp.dao.TaskDao;

/**
 * @author VinitGore
 *
 */
public class TaskService {

	public boolean addTask(Task task) throws Exception {
		if (task.getTask() == "" || task.getTask() == null) {
			System.out.println("Task name not entered!");
			return false;
		}

		TaskDao taskDao = new TaskDao();

		if (taskDao.createTask(task)) {
			System.out.println("Task successfully added!");
			return true;
		} else {
			System.out.println("Task not added");
			return false;
		}
	}

	public List<Task> getAllTasks() throws Exception {
		TaskDao taskDao = new TaskDao();
		List<Task> tasksFromDB = taskDao.getAllTasks();
		int length = tasksFromDB.size();
		System.out.println(" Sr.No.  | Task Name                | Status           | Actions      ");
		for (Task task : tasksFromDB) {
			String formattedString = String.format("%-10d|%-26s|%-18s|", task.getId(), task.getTask(),
					task.getTaskStatus());
			System.out.println(formattedString);
		}
		return tasksFromDB;
	}
}
