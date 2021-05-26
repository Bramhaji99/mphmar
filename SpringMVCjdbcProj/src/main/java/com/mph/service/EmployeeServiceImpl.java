package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mph.dao.EmployeeDao;
import com.mph.entity.Employee;


public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public int addEmployee(Employee employee) {
		
		return employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee getAEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAEmployee();
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(eid);
		
	}

}
