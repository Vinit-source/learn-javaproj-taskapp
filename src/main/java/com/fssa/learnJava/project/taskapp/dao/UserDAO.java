/**
 * 
 */
package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.learnJava.project.taskapp.dao.exception.DAOException;
import com.fssa.learnJava.project.taskapp.model.User;

/**
 * @author BharathwajSoundarara
 *
 */
public class UserDAO {

	public boolean createUser(User user) throws DAOException {

		String query = "INSERT INTO users (user_name, email_id, password) VALUES ( ?, ?, ? );";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			int rows2 = pst.executeUpdate();
			if (rows2 > 0)
				return true;
			else
				return false;
			// Example for multi-catch
		} catch (SQLException e) { // FIXME: Why ClassNotFoundException occurs?
			throw new DAOException(e);
		}
	}

	public User getUserByUserName(String userName) throws DAOException {
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
			throw new DAOException(sqe);
		}
		return userFromDB;
	}

	public User getUserByEmail(String email) throws DAOException {

		User userFromDB = new User();
		final String selectQuery = "SELECT user_id,user_name,password,email_id FROM users WHERE email_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {

			pst.setString(1, email);

			// Step 04: Execute SELECT Query
			try (ResultSet rs = pst.executeQuery();) {

				// Step 06: Iterate the result
				if (rs.next()) {
					userFromDB.setId(rs.getInt("user_id"));
					userFromDB.setName(rs.getString("user_name"));
					userFromDB.setPassword(rs.getString("password"));
					userFromDB.setEmail((rs.getString("email_id")));

				} 
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return userFromDB;
	}

	/**
	 * @param fromDb
	 * @param b
	 * @throws DAOException
	 */
	public boolean changeLoginStatus(User user, boolean loginStatus) throws DAOException {
		boolean methodStatus = false;
		final String selectQuery = "UPDATE users SET is_logged_in = ? WHERE email_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {

			pst.setBoolean(1, loginStatus);
			pst.setString(2, user.getEmail());

			int rows = pst.executeUpdate();

			methodStatus = rows > 0;
			return methodStatus;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
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