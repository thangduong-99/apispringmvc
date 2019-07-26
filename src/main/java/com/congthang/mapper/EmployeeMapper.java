package com.congthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.congthang.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee>{
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setEmpName(rs.getString("name"));
		employee.setEmpNo(rs.getString("no"));
		employee.setPosition(rs.getString("position"));
		return employee;
	}
}
