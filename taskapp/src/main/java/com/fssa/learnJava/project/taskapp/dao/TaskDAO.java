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
import com.fssa.learnJava.project.taskapp.dao.exception.DAOException;
import com.fssa.learnJava.project.taskapp.utils.LocalDateTimeAttributeConverter;

/**
 * @author VinitGore
 *
 */
public class TaskDAO {

	/**
	 * 
	 */
	public boolean createTask(Task task) throws DAOException {
		String query = "INSERT INTO tasks (task, task_status, user_id) VALUES (?, ?, ?);";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, task.getTask());
			pst.setString(2, task.getTaskStatus());
			pst.setInt(3, task.getCreatedBy().getId());
			int rows = pst.executeUpdate();

			return (rows > 0);

		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	public List<Task> getAllTasks() throws DAOException {
		String query = "SELECT id, task, task_status, completed_at, is_deleted FROM tasks WHERE is_deleted = 0";

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
				LocalDateTime completedAt = LocalDateTimeAttributeConverter
						.convertToLocalDateTime(rs.getTimestamp("completed_at"));

				task.setId(id);
				task.setTask(taskName);
				task.setTaskStatus(taskStatus);
				task.setCompletedAt(completedAt);
				tasks.add(task);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return tasks;

	}

	public boolean editTask(Task task) throws DAOException {

		boolean methodStatus = false;
		String query = "UPDATE tasks SET task = ?, task_status = ?, completed_at = ? WHERE id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, task.getTask());
			pst.setString(2, task.getTaskStatus());
			pst.setTimestamp(3, LocalDateTimeAttributeConverter.convertToSQLTimestamp(task.getCompletedAt()));
			pst.setInt(4, task.getId());

			int rows = pst.executeUpdate();

			methodStatus = rows > 0;
			return methodStatus;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * @param task
	 * @throws DAOException
	 */
	public boolean removeTask(Task task) throws DAOException {
		String query = "UPDATE tasks SET is_deleted = ? WHERE id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setBoolean(1, true);
			pst.setInt(2, task.getId());

			int rows = pst.executeUpdate();

			return rows > 0;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e);
		} 
	}

}
