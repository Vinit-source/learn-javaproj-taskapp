/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao.exception;

/**
 * @author VinitGore
 *
 */
public class DAOException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 424307628927676856L;

	public DAOException(String msg) {
		super (msg);
	}
	public DAOException(Throwable ex) {
		super (ex);
	}
	public DAOException(String msg, Throwable ex) {
		super (msg,ex);
	}
}