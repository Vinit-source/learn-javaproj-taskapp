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

	/**
	 * 
	 */
	public boolean createTask(Task task) throws DaoException {
		String query = "INSERT INTO tasks (task, task_status) VALUES (?, ?);";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, task.getTask());
			pst.setString(2, task.getTaskStatus());

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
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {

			List<Task> tasks = new ArrayList<Task>();
			while (rs.next()) {

				Task task = new Task();

				int id = rs.getInt("id");
				String taskName = rs.getString("task");
				String taskStatus = rs.getString("task_status");

				task.setId(id);
				task.setTask(taskName);
				task.setTaskStatus(taskStatus);
				tasks.add(task);
			}
			return tasks;
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}

	}
}
