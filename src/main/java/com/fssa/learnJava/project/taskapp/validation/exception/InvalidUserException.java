/**
 * 
 */
package com.fssa.learnJava.project.taskapp.validation.exception;

/**
 * @author VinitGore
 *
 */
public class InvalidUserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable ex) {
		super(ex);
	}

	public InvalidUserException(String msg, Throwable ex) {
		super(msg, ex);
	}
}