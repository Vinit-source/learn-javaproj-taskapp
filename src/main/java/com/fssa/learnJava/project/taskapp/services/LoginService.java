package com.fssa.learnJava.project.taskapp.services;

import com.fssa.learnJava.project.taskapp.dao.UserDao;
import com.fssa.learnJava.project.taskapp.model.User;

/**
 * @author BharathwajSoundarara
 *
 */
public class LoginService {

	UserDao userdao;

	public LoginService() throws Exception {
		this.userdao = new UserDao();
	}

	public User login(User user) throws Exception {

		User fromDb = this.userdao.getUserByEmail(user.getEmail());

		// No User found hence login has failed
		if (fromDb.getEmail() == null || fromDb.getEmail() == "") {
			System.out.println("NO USER Found");
			return fromDb;
		}

		else if (fromDb.getPassword().equals(user.getPassword())) {
			fromDb = this.userdao.setIsLoggedInAndGetDBUser(user.getEmail());
			System.out.println("LOGIN SUCCESSFUL");
			return fromDb;
		} else {
			System.out.println("Invalid Login Credentials");
			return fromDb;
		}

	}

	public boolean registerUser(User user) throws Exception {
		User userFromDb = userdao.getUserByEmail(user.getEmail());

		if (userFromDb.getEmail() != null && userFromDb.getEmail().equals(user.getEmail())) {
			System.out.println("Email id " + user.getEmail() + " is already registered");
			return false;
		} else if (user.getPassword().length() < 8) {
			System.out.println("Password length must have minimum 8 characters");
			return false;
		} else {
			if (userdao.createUser(user)) {
				System.out.println("Registration Successful");
				return true;
			} else {
				System.out.println("Registration Failed");
				return false;
			}
		}
	}
}