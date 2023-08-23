package com.fssa.learnJava.project.taskapp.validation.exception;

public class InvalidTaskException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTaskException(String msg) {
		super(msg);
	}

	public InvalidTaskException(Throwable ex) {
		super(ex);
	}

	public InvalidTaskException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
