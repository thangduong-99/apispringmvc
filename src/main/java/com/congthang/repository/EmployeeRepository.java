package com.congthang.repository;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.congthang.entity.Employee;
import com.congthang.mapper.EmployeeMapper;


@Repository
public class EmployeeRepository {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplateObject.query(sql, new EmployeeMapper());
	}
	public Employee findById(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplateObject.queryForObject(sql, new EmployeeMapper(), id);
	}
	public void update(Employee employee) {
		String sql = "UPDATE customer SET name = ?, no = ?, position = ? WHERE id = ? ";
		jdbcTemplateObject.update(sql, employee.getEmpName(), employee.getEmpNo(), employee.getPosition(),employee.getId());
	}
	public void save(Employee employee) {
		String sql = "INSERT INTO customer (name, no , position) VALUES (?, ?, ?)";
		jdbcTemplateObject.update(sql, employee.getEmpName(), employee.getEmpNo(), employee.getPosition());
	}
	public void delete(int id) {
		String sql = "DELETE FROM employee WHERE id = " + id;
		jdbcTemplateObject.update(sql);
	}
}