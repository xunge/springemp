package com.agiletest.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agiletest.dao.UserDAO;
import com.agiletest.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User findByName(String username) throws Exception {
		//System.out.println("username in UserDAOImpl = "+ username);
		String sql = "select * from user where username = ?";
		//System.out.println(jdbcTemplate);
		return (User)jdbcTemplate.queryForObject(sql, new Object[]{username},new int[]{java.sql.Types.VARCHAR},new UserRowMapper());
	}

	public void addUser(String email, String username, String password) {
		String sql = "insert into user(email,username,password) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[]{email,username,password},new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
		
	}

	public User findByEmail(String email) throws Exception {
		String sql = "select max(email) from user where email = ?";	
		return  jdbcTemplate.queryForObject(sql, new Object[]{email},new int[]{java.sql.Types.VARCHAR},new UserRowMapper2());
	}

}
