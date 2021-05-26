package com.mph.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mph.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL_EMP="select * from mph_table";
	private final String CREATE_EMP="insert into mph_table(id,name,address,email)values(?,?,?,?)";
	private final String UPDATE_EMP="update mph_table set name=?,address=?,email=? where id=?";
	private final String DELETE_EMP="delete from mph_table where id=?";
	
	public EmployeeDaoImpl(DataSource dataSource) {
		System.out.println(dataSource);
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public int addEmployee(Employee employee) {
		jdbcTemplate.update(CREATE_EMP,employee.getId(),employee.getName(),employee.getAddress(),employee.getEmail());
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_ALL_EMP, new EmployeeRowMapper());
	}

	@Override
	public Employee getAEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_EMP,employee.getName(),employee.getAddress(),employee.getEmail(),employee.getId());
		
	}

	@Override
	public void deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_EMP,eid);
		
	}

}
