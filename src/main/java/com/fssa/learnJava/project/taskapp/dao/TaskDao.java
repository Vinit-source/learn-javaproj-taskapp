/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * @author VinitGore
 *
 */
public class TaskDao {

	Connection connection;
	PreparedStatement pst;
	Statement stmt;
	private List<Task> tasks;

	public TaskDao() throws Exception {
		connection = ConnectionUtil.getConnection();
		stmt = connection.createStatement();
		this.tasks = new ArrayList<>();
	}

	/**
	 * 
	 */
	public boolean createTask(Task task) throws Exception {
		// Add to List
		tasks.add(task);
		
		// Add to database
		connection = ConnectionUtil.getConnection();
		String query = "INSERT INTO tasks (task, taskStatus) VALUES ( ?, ? );";
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, task.getTask());
		pst.setString(2, "PENDING");
		
		int rows = pst.executeUpdate();
		
		pst.close();
		connection.close();
		
		if (rows > 0)
			return true;
		else
			return false;
	}
	
	public List<Task> getAllTasks() throws Exception {
		connection = ConnectionUtil.getConnection();
		String query = "SELECT * FROM tasks;";
		PreparedStatement pst = connection.prepareStatement(query);
		
		ResultSet rs = pst.executeQuery();
		
		this.tasks.clear();
		while (rs.next()) {
			
			Task task = new Task();
			
			int id = rs.getInt("id");
			String taskName = rs.getString("task");
			String taskStatus = rs.getString("taskStatus");
			
			task.setId(id);
			task.setTask(taskName);
			task.setTaskStatus(taskStatus);
			this.tasks.add(task);
		}
		
		return this.tasks;
	}
}
