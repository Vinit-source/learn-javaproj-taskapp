/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import java.sql.SQLException;

import com.fssa.learnJava.project.taskapp.dao.UserDAO;
import com.fssa.learnJava.project.taskapp.dao.exception.DAOException;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;
import com.fssa.learnJava.project.taskapp.validation.UserValidator;
import com.fssa.learnJava.project.taskapp.validation.exception.InvalidUserException;
import com.fssa.learnJava.project.taskapp.validation.exception.ValidatorInitializationException;

/**
 * @author BharathwajSoundarara
 *
 */
public class UserService {

	private UserDAO userDAO;
	private UserValidator userValidator;

	public UserService() {
		this.userDAO = new UserDAO();
		this.userValidator = new UserValidator();

	}

	public boolean login(User user) throws ServiceException {
		User fromDb;
		try {
			userValidator.validateLoggingInUser(user);

			fromDb = userDAO.getUserByEmail(user.getEmail());
			if (fromDb != null)
				return user.getPassword().equals(fromDb.getPassword());
			else
				return false;
		} catch (DAOException | InvalidUserException ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}

	}

	public boolean registerUser(User user) throws ServiceException {
		User userFromDb;
		try {
			userValidator.validateRegisteringUser(user);
			userFromDb = userDAO.getUserByEmail(user.getEmail());

			// TODO: Add user_name, email and attributes first before adding business logic
			if (userFromDb != null && userFromDb.getEmail() != null && userFromDb.getEmail().equals(user.getEmail())) {
				throw new ServiceException("User already registered!");
			} else {
				return userDAO.createUser(user);
			}
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

//	public User getLoggedInUser() throws ServiceException {
//		try {
//			return userDAO.findLoggedInUser();
//		} catch (DAOException e) {
//			throw new ServiceException(e);
//		}
//	}

//	public boolean logout() throws ServiceException {
//		try {
//			User user = getLoggedInUser();
//			return userDAO.changeLoginStatus(user, false);
//		} catch (DAOException e) {
//			throw new ServiceException(e);
//		}
//	}
}