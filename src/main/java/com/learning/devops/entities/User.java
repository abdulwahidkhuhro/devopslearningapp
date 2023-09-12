package com.learning.devops.entities;

import java.util.regex.Pattern;

public class User {

	private String name;
	private String email;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGmailAddress() {
        String gmailRegex = "^[a-zA-Z0-9+_.-]+@gmail\\.com$";

        Pattern pattern = Pattern.compile(gmailRegex);
        
        if(email != null && !email.isEmpty() ) {
        	return  pattern.matcher(email).matches();
        }
       
        return false;
    }
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
