package com.fssa.learnJava.project.taskapp.validation;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.validation.exception.InvalidUserException;

public class UserValidator {

	// Use to validate login
	public boolean validateLoggingInUser(User user) throws InvalidUserException {
//		if (user == null) {
//			throw new InvalidUserException("Empty User");
//		}
//		if (user.getPassword() == null) {
//			throw new InvalidUserException("Password is null");
//		} else if (user.getPassword().isEmpty()) {
//			throw new InvalidUserException("Password is empty");
//		} else if (user.getPassword().length() < this.minLength) {
//			throw new InvalidUserException("Password is less expected length of " + this.minLength);
//		} else if (!this.validateEmail(user.getEmail())) {
//			throw new InvalidUserException("Please enter a valid email");
//		} else {
//			return true;
//		}
		return validateUserNotNull(user) && validateEmail(user.getEmail()) && validatePassword(user.getPassword());
	}

	// Use to validate register
	public boolean validateRegisteringUser(User user) throws InvalidUserException {
		return validateUser(user);

		// if (user == null) {
//			throw new InvalidUserException("Empty User");
//		}
//		if (user.getName() == null) {
//			throw new InvalidUserException("User name is empty");
//		} else if (user.getName().isEmpty()) {
//			throw new InvalidUserException("User name is empty");
//		} else if (user.getPassword() == null) {
//			throw new InvalidUserException("Password is null");
//		} else if (user.getPassword().isEmpty()) {
//			throw new InvalidUserException("Password is empty");
//		} else if (user.getPassword().length() < this.minLength) {
//			throw new InvalidUserException("Password is less expected length of " + this.minLength);
//		} else if (!this.validateEmail(user.getEmail())) {
//			throw new InvalidUserException("Please enter a valid email");
//		} else {
//			return true;
//		}

	}

//	public boolean validateEmail(String emailAddress) {
//		final String emailValidationRegEx = "^(.+)@(\\S+)$";
//		if (emailAddress == null) {
//			return false;
//		} else if (emailAddress.isEmpty()) {
//			return false;
//		} else {
//			return Pattern.compile(emailValidationRegEx).matcher(emailAddress).matches();
//		}
//	}

	public boolean validateUser(User user) throws InvalidUserException {
		return validateUserNotNull(user) && validateEmail(user.getEmail()) && validateName(user.getName())
				&& validatePassword(user.getPassword());

	}

	public boolean validateUserNotNull(User user) throws InvalidUserException {
		if (user != null) {
			return true;
		} else {
			throw new InvalidUserException("User should not be null.");
		}
	}

	public boolean validateEmail(String email) throws InvalidUserException {
		String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$";

//		if (regex.matches(email)) {
			if (email.matches(regex)) {
			return true;
		} else {
			throw new InvalidUserException("Invalid email.");
		}
	}

	public boolean validatePassword(String password) throws InvalidUserException {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

		if (password.matches(regex)) {
			return true;
		} else {
			throw new InvalidUserException("Invalid password.");
		}
	}

	public boolean validateName(String name) throws InvalidUserException {
		if (name.length() >= 3 && name.length() <= 30 && name.matches("^[A-Za-z\\s]+$")) {
			return true;
		} else {
			throw new InvalidUserException("Invalid name.");
		}
	}

}
