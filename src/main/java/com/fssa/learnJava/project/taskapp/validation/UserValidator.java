package com.fssa.learnJava.project.taskapp.validation;

import java.util.regex.Pattern;
import com.fssa.learnJava.project.taskapp.validation.InvalidUserException;
import com.fssa.learnJava.project.taskapp.model.User;

public class UserValidator {

	private int minLength;

	public UserValidator(int minLength) throws ValidatorInitializationException {
		if (minLength < 0) {
			throw new ValidatorInitializationException("Invalid length");
		} else {
			this.minLength = minLength;
		}
	}
	
	// Use to validate login 
	public boolean validateLoggingInUser(User user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("Empty User");
		}
		if (user.getPassword() == null) {
			throw new InvalidUserException("Password is null");
		} else if (user.getPassword().isEmpty()) {
			throw new InvalidUserException("Password is empty");
		} else if (user.getPassword().length() < this.minLength) {
			throw new InvalidUserException("Password is less expected length of " + this.minLength);
		} else if (!this.validateEmail(user.getEmail())) {
			throw new InvalidUserException("Please enter a valid email");
		} else {
			return true;
		}

	}

	// Use to validate register
	public boolean validateRegisteringUser(User user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("Empty User");
		}
		if (user.getName() == null) {
			throw new InvalidUserException("User name is empty");
		} else if (user.getName().isEmpty()) {
			throw new InvalidUserException("User name is empty");
		} else if (user.getPassword() == null) {
			throw new InvalidUserException("Password is null");
		} else if (user.getPassword().isEmpty()) {
			throw new InvalidUserException("Password is empty");
		} else if (user.getPassword().length() < this.minLength) {
			throw new InvalidUserException("Password is less expected length of " + this.minLength);
		} else if (!this.validateEmail(user.getEmail())) {
			throw new InvalidUserException("Please enter a valid email");
		} else {
			return true;
		}

	}

	public boolean validateEmail(String emailAddress) {
		final String emailValidationRegEx = "^(.+)@(\\S+)$";
		if (emailAddress == null) {
			return false;
		} else if (emailAddress.isEmpty()) {
			return false;
		} else {
			return Pattern.compile(emailValidationRegEx).matcher(emailAddress).matches();
		}
	}

}
