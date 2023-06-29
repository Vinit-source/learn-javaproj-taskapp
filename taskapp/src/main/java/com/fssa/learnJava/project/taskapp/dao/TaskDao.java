/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.dao.exception.DaoException;
import com.fssa.learnJava.project.taskapp.utils.LocalDateTimeAttributeConverter;

/**
 * @author VinitGore
 *
 */
public class TaskDao {
	
	private LocalDateTimeAttributeConverter dtConverter;
	public TaskDao () {
		this.dtConverter = new LocalDateTimeAttributeConverter();
	}

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
		String query = "SELECT id, task, task_status, completed_at FROM tasks";

		List<Task> tasks;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {

			tasks = new ArrayList<Task>();
			while (rs.next()) {

				Task task = new Task();

				int id = rs.getInt("id");
				String taskName = rs.getString("task");
				String taskStatus = rs.getString("task_status");
				LocalDateTime completedAt = dtConverter
						.convertToEntityAttribute(rs.getTimestamp("completed_at"));

				task.setId(id);
				task.setTask(taskName);
				task.setTaskStatus(taskStatus);
				task.setCompletedAt(completedAt);
				tasks.add(task);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}
		return tasks;

	}

	public boolean updateTask(Task task) throws DaoException {

		boolean status = false;
		String query = "UPDATE tasks SET task = ?, task_status = ?, completed_at = ? WHERE id = ?";
		LocalDateTimeAttributeConverter dtConverter = new LocalDateTimeAttributeConverter();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, task.getTask());
			pst.setString(2, task.getTaskStatus());
			pst.setTimestamp(3, dtConverter.convertToDatabaseColumn(task.getCompletedAt()));
			pst.setInt(4, task.getId());

			int rows = pst.executeUpdate();

			status = rows > 0;
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}
		return status;
	}

}
