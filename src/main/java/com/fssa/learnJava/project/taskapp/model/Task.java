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
	private boolean isDeleted;
	private User createdBy;

	/**
	 * @param task
	 * @param taskStatus
	 */
	public Task(String task, String taskStatus) {
		super();
		this.task = task;
		this.taskStatus = taskStatus;
	}

	/**
	 * @param id
	 * @param task
	 * @param taskStatus
	 */
	public Task(int id, String task, String taskStatus) {
		super();
		this.id = id;
		this.task = task;
		this.taskStatus = taskStatus;
	}

	/**
	 * 
	 */
	public Task() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param taskName
	 * @param taskStatus2
	 * @param createdBy2
	 */
	public Task(String taskName, String taskStatus, User createdBy) {
		this.task = taskName;
		this.taskStatus = taskStatus;
		this.createdBy = createdBy;
	}

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

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}
