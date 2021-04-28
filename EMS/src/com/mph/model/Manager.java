package com.mph.model;

import com.mph.model.Employee;
import com.mph.model.Salary;
public class Manager extends Employee {
	private String dept;
	private int eid;
	private String ename;
	private Salary salary;
	
	public void setEid(int eid) {
		this.eid=eid;
	}
	public int getEid() {
		return eid;
	}
	public void setEname(String ename) {
		this.ename=ename;
	}
	public String getEname() {
		return ename;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		// TODO Auto-generated method stub
		this.salary=salary;
	}
		
	public void setDept(String dpt) {
		this.dept=dpt;
	}
	public String getDept()
	{
	return dept;
	}
	@Override
	public String toString() {
		return "Manager [dept=" + dept + ", eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}


}
