/**
 * 
 */
package com.fssa.learnJava.project.taskapp.validation;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.validation.exception.InvalidUserException;

public class TestUserValidator {

    private UserValidator userValidator;

    @BeforeEach
    public void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    public void testValidUser()  {
        User user = new User("JohnDoe", "example@example.com", "Passw0rd!");
        try {
			assertTrue(userValidator.validateUser(user));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
    }
    
    @Test
    public void testInvalidNameLength1()  {
        User user = new User("Jo", "example@example.com", "Passw0rd!");
        try {
			userValidator.validateUser(user);
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
			assertEquals("Invalid name.", e.getMessage());
		}
    }

    @Test
    public void testInvalidNameLength() {
        User user = new User("Jo", "example@example.com", "Passw0rd!");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validateName(user.getName()));
        assertEquals("Invalid name.", e.getMessage());
    }

    @Test
    public void testInvalidEmailMissingAtDot() {
        User user = new User("JohnDoe", "invalid_email", "Passw0rd!");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validateEmail(user.getEmail()));
        assertEquals("Invalid email.", e.getMessage());
    }
    
    @Test
    public void testEmailIDAtMissing() {
        User user = new User("JohnDoe", "invalid_email", "Passw0rd!");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validateEmail(user.getEmail()));
        assertEquals("Invalid email.", e.getMessage());
    }

    @Test
    public void testInvalidPasswordLength() {
        User user = new User("JohnDoe", "example@example.com", "weak");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validatePassword(user.getPassword()));
        assertEquals("Invalid password.", e.getMessage());
    }
    
    @Test
    public void testPasswordWithoutSpecialCharacters() {
        User user = new User("JohnDoe", "example@example.com", "Password");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validatePassword(user.getPassword()));
        assertEquals("Invalid password.", e.getMessage());
    }
    
    @Test
    public void testPasswordWithoutUppercase() {
        User user = new User("JohnDoe", "example@example.com", "password!");
        InvalidUserException e = assertThrows(InvalidUserException.class, () -> userValidator.validatePassword(user.getPassword()));
        assertEquals("Invalid password.", e.getMessage());
    }

 // Additional test cases can be added for edge cases and other scenarios

}
