/**
 * 
 */
package com.fssa.learnJava.project.taskapp.model;


/**
 * @author VinitGore
 *
 */
public class Task {
	
	private int id;
	private String task;

//	public enum TaskStatus {
//	    PENDING("Pending"),
//	    COMPLETED("Completed");
//
//	    private String status;
//
//	    private TaskStatus(String status) {
//	        this.status = status;
//	    }
//
//	    public String getStatus() {
//	        return status;
//	    }
//	}
	private String taskStatus;

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
	public void setTaskStatus(String taskStatus) throws Exception {
		String [] validStatuses = {"PENDING", "COMPLETED"};
		boolean isValid = false;

        for (String element : validStatuses) {
            if (element.equals(taskStatus)) {
                isValid = true;
                break;
            }
        }
		
		if (isValid) {			
			this.taskStatus = taskStatus;
		} else {
			throw new Exception("Task Status should be among the values: Pending and Completed.");
		}
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

}
