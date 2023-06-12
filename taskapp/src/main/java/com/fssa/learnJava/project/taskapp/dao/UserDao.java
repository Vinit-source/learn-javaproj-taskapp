/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.learnJava.project.taskapp.dao.exception.DaoException;
import com.fssa.learnJava.project.taskapp.model.User;

/**
 * @author BharathwajSoundarara
 *
 */
public class UserDao {

	
	public boolean createUser(User user) throws DaoException {

		String query = "INSERT INTO users (user_name, email_id, password) VALUES ( ?, ?, ? );";

		try (	
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			int rows2 = pst.executeUpdate();
			if (rows2 > 0)
				return true;
			else
				return false;
			// Example for multi catch
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {	// FIXME: Why ClassNotFoundException occurs?
			throw new DaoException(e);
		}

	}

	public void updateUser(User user) {

	}

	public User getUserByUserName(String userName) throws DaoException {
		User userFromDB = new User();

		// Step 04: Execute SELECT Query
		final String selectQuery = "SELECT user_id,user_name,password,email_id FROM users WHERE user_name = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			// Step 05: Get the ResultSet
			pst.setString(1, userName);
			try (ResultSet rs = pst.executeQuery()) {

				// Step 06: Iterate the result
				if (rs.next()) {
					userFromDB.setId(rs.getInt("user_id"));
					userFromDB.setName(rs.getString("user_name"));
					userFromDB.setPassword(rs.getString("password"));
					userFromDB.setEmail((rs.getString("email_id")));
				}
			}
		} catch (SQLException sqe) {
			throw new DaoException(sqe);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}

		return userFromDB;
	}

	public User getUserByEmail(String email) throws DaoException {

		User userFromDB = new User();
		final String selectQuery = "SELECT user_id,user_name,password,email_id FROM users WHERE email_id = ?";

		try (
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {

			pst.setString(1, email);
			
			// Step 04: Execute SELECT Query
			try (ResultSet rs = pst.executeQuery(); ) {

				// Step 06: Iterate the result
				if (rs.next()) {
					userFromDB.setId(rs.getInt("user_id"));
					userFromDB.setName(rs.getString("user_name"));
					userFromDB.setPassword(rs.getString("password"));
					userFromDB.setEmail((rs.getString("email_id")));

				}
			}

		} catch (SQLException sqe) {
			throw new DaoException(sqe);
		} catch (ClassNotFoundException e) {	// FIXME: Throwing separate exceptions separately - is it a best practice?
			throw new DaoException(e);
		}
		return userFromDB;
	}

//	@Override
//	public void finalize() {
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}