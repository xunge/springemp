package com.agiletest.dao;

import java.util.List;
import java.util.Map;

import com.agiletest.model.User;

public interface UserDAO {
	public User findByName(String username) throws Exception;
	
	public User findByEmail(String email) throws Exception;
	
	public void addUser(String email, String username, String password) throws Exception;
}
