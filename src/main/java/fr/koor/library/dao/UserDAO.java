package fr.koor.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.koor.library.business.User;

public class UserDAO extends DAOContext{
	
	public User isValidUser(String login, String password) {
		
		try (Connection con= DriverManager.getConnection(dbURL, dbLogin, dbPassword)){
			ResultSet result;
			String str= "SELECT * FROM T_users WHERE login =? and password=?";
			PreparedStatement statment = con.prepareStatement(str);
			statment.setString(1, login);
			statment.setString(2,password);
			
			result= statment.executeQuery();
			if (result.next()) {
				return new User(
						result.getInt("IdUser"),
						result.getString("Login"),
						result.getString("Password"),
						result.getInt("ConnectionNumber")
						);
				
			} else {
				return null;

			}
			
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
		
	}

}
