package com.agiletest.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agiletest.model.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int index) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
