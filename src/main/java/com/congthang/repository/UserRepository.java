package com.congthang.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.congthang.entity.User;


@Repository
public class UserRepository {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	Connection conn = null;
	PreparedStatement stm = null;
	public boolean checkLogin(User user) {
		String query = "SELECT * FROM user WHERE username=? AND password=?";

		try {
			conn = dataSource.getConnection();
			stm = conn.prepareStatement(query);

			stm.setString(1, user.getUserName());
			stm.setString(2, user.getPassWord());

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void save(User user) {
		String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
		jdbcTemplateObject.update(sql, user.getUserName(), user.getPassWord());
	}
}
