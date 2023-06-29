/**
 * 
 */
package com.fssa.learnJava.project.taskapp.model;

import java.time.LocalDateTime;

/**
 * @author VinitGore
 *
 */
public class Task {

	private int id;
	private String task;
	private String taskStatus;
	private LocalDateTime completedAt;

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * @return the taskStatus
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * @param taskStatus the taskStatus to set
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the completedAt
	 */
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	/**
	 * @param completedAt the completedAt to set
	 */
	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}

}
