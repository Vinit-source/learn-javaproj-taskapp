/**
 * 
 */
package com.fssa.learnJava.project.taskapp.services;

import java.sql.SQLException;

import com.fssa.learnJava.project.taskapp.dao.UserDAO;
import com.fssa.learnJava.project.taskapp.dao.exception.DAOException;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;
import com.fssa.learnJava.project.taskapp.validation.InvalidUserException;
import com.fssa.learnJava.project.taskapp.validation.UserValidator;
import com.fssa.learnJava.project.taskapp.validation.ValidatorInitializationException;

/**
 * @author BharathwajSoundarara
 *
 */
public class UserService {

	private UserDAO userdao;
	private UserValidator userValidator;
	private final int minPasswordLen = 8;

	public UserService() throws ServiceException {
		try {
			this.userdao = new UserDAO();
			this.userValidator = new UserValidator(this.minPasswordLen);
		} catch ( ValidatorInitializationException e) {
			throw new ServiceException(e);
		}

	}


	public String login(User user) throws ServiceException {
		User fromDb;

		try {
			if (!userValidator.validateLoggingInUser(user)) {
				throw new ServiceException("Invalid input credentials. Please meet the required input formats.");
			}
		} catch (InvalidUserException e1) {
			throw new ServiceException("Invalid input credentials. Please meet the required input formats.");
		}

		try {
			fromDb = this.userdao.getUserByEmail(user.getEmail());

			if (user.getPassword().equals(fromDb.getPassword())) {
				return "SUCCESSFUL";
//				return "UNSUCCESFUL";
			} else {
				return "Invalid Login Credentials";
			}
		} catch (DAOException ex) {
			throw new ServiceException(ex);
		}

	}

	public String registerUser(User user) throws ServiceException {
		User userFromDb;
		try {
			if (!userValidator.validateRegisteringUser(user)) {
				throw new ServiceException("Invalid User");
			}
		} catch (InvalidUserException e1) {
			throw new ServiceException("Invalid User", e1);
		}

		try {
			userFromDb = userdao.getUserByEmail(user.getEmail());
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		// TODO: Add user_name, email and attributes first before adding business logic
		if (userFromDb.getEmail() != null && userFromDb.getEmail().equals(user.getEmail())) {
			return "Email id " + user.getEmail() + " is already registered";
		} else {
			try {
				if (userdao.createUser(user))
					return "Registration Successful";
				else
					return "Registration Failed";
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}
	}
}