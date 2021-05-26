package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Employee;
import com.mph.service.EmployeeService;

@RestController
@RequestMapping(value="/empms")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/addemp")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{
		int eid=employeeService.addEmployee(employee);
		return ResponseEntity.ok().body("New Employee with eid=" +eid+" stored successfully");
	}
	@GetMapping("/allemp")
	public ResponseEntity<List<Employee>> showEmployee()
	{
		List<Employee>emplist=employeeService.getAllEmployee();
		return ResponseEntity.ok().body(emplist);
		
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
		return ResponseEntity.ok().body("Employee with eid= " +employee.getId()+"updated successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().body("deleted successfully");
	}
}
