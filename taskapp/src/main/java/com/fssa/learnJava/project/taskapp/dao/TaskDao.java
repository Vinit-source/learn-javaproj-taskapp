/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.dao.exception.DaoException;

/**
 * @author VinitGore
 *
 */
public class TaskDao {

	private List<Task> tasks;

	public TaskDao() {
		this.tasks = new ArrayList<Task>();
	}

	/**
	 * 
	 */
	public boolean createTask(Task task) throws DaoException {
		// Add to List
		this.tasks.add(task);

		String query = "INSERT INTO tasks (task, task_status) VALUES (?, ?);";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, task.getTask());
			pst.setString(2, "PENDING");

			int rows = pst.executeUpdate();

			if (rows > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Task> getAllTasks() throws DaoException {
		String query = "SELECT id, task, task_status FROM tasks";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {

			ResultSet rs = pst.executeQuery();
			
			this.tasks.clear();
			while (rs.next()) {

				Task task = new Task();

				int id = rs.getInt("id");
				String taskName = rs.getString("task");
				String taskStatus = rs.getString("task_status");

				task.setId(id);
				task.setTask(taskName);
				task.setTaskStatus(taskStatus);
				this.tasks.add(task);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}

		return this.tasks;
	}
}
