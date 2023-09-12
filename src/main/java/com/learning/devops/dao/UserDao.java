package com.learning.devops.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.learning.devops.entities.User;

public class UserDao {

	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public boolean isUserExists(String email) {
		
		boolean isExists = false;
		
		try {
			
			String query = "select * from user where email = ? ;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				isExists = true;
			}
			
		}catch(Exception exception) {
			System.out.println("UserDao -> isUserExists method : "+ exception.getMessage());
			exception.printStackTrace();
		}
		return isExists;
	}
	
	public boolean saveUser(User user) {
		
		boolean isSaved = false;
		
		try {
			String query = "insert into user (name, email, password) values (?,?,?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			
			preparedStatement.executeUpdate();
			
			isSaved = true;
		}catch(Exception exception) {
			System.out.println("UsreDao -> saveUser method : "+exception.getMessage());
			exception.printStackTrace();
		}
		
		return isSaved;
	}
	
	public boolean updateUser(User user) {
		
		boolean isUpdated = false;
		
		try {
			String query = "update user set name=?, email=?, password=? where email=?";
			
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			
			preparedStatement.setString(4, user.getEmail());
			
			preparedStatement.executeUpdate();
			
			isUpdated = true;
			
		}catch(Exception exception) {
			System.out.println("UserDao -> updateUser method : "+exception.getMessage());
			exception.printStackTrace();
		}
		
		return isUpdated;
	}
	
	public User getUserByEmailandPassword(String email, String password) {
		
		User user = null;
		try {
			String query = "select * from user where email = ? and password = ?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				user = new User();
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return user;
		
	}
	
	
}
