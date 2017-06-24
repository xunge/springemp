package com.agiletest.service;


public interface UserService {
	public boolean login(String username,String password) throws Exception;

	public int checkEmailExist(String email) throws Exception;
	//public User findUserByEmail(String email);
}
