package com.mph.service;

import java.util.List;

import com.mph.entity.Employee;

public interface EmployeeService {

	public int addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getAEmployee();
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int eid);
	
}
