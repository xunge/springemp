package com.agiletest.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiletest.dao.UserDAO;
import com.agiletest.model.User;
import com.agiletest.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	public boolean login(String username, String password) throws Exception {
		//System.out.println("username in UserServiceImpl = "+username);
		User user = userDAO.findByName(username);
		if(user == null) {
			return false;
		}
		if(password.equals(user.getPassword())){
			return true;
		}
		return false;
	}

	public int checkEmailExist(String email) throws Exception {
		User user = userDAO.findByEmail(email);
		if(user == null) {
			return 0;
		} else {
			return 1;
		}
	}
}
