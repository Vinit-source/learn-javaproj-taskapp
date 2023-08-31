/**
 * 
 */
package com.fssa.learnJava.project.taskapp.validation.exception;

/**
 * @author Vinit Gore
 *
 **/
public class NoDataPresentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataPresentException(String msg) {
		super(msg);
	}

	public NoDataPresentException(Throwable ex) {
		super(ex);
	}

	public NoDataPresentException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
