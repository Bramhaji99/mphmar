package com.mph.exception;

public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(){
		System.out.println("user not found");
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException ";
	}
	

}
