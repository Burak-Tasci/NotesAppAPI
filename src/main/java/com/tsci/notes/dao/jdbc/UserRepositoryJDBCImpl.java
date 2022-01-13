package com.tsci.notes.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tsci.notes.dao.UserRepository;
import com.tsci.notes.model.User;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RowMapper<User> rowMapperUser = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user = new User();
			user.setId(rs.getInt("ID"));
			user.setName(rs.getString("Name"));
			user.setSurname(rs.getString("Surname"));
			user.setMail(rs.getString("Mail"));
			user.setPassword(rs.getString("Password"));
			user.setTitle(rs.getString("Title"));
			return user;
		}
		
		
	};
	
	
	@Override
	public List<User> findUsers() {
		
		// Query to get all users
		String sql = "SELECT * FROM [User]";
		// returning all users by getting them with jdbcTemplate query method
		return jdbcTemplate.query(sql,rowMapperUser);
	}

	@Override
	public List<User> findByTitle(String title) {
		
		// Query to get all users which has the wanted title
		String sql = "SELECT * FROM [User] AS u WHERE u.Title = ?";
		// returning them
		return jdbcTemplate.query(sql, rowMapperUser, title);
	}

	@Override
	public List<User> findByName(String name) {
		
		// Query to get all users which has the wanted name
		String sql = "SELECT * FROM [User] AS u WHERE u.Name = ?";
		// returning them
		return jdbcTemplate.query(sql, rowMapperUser, name);
	}

}
