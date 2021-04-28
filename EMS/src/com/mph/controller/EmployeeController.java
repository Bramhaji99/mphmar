package com.mph.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mph.dao.EmployeeDao;
import com.mph.model.Employee;
import com.mph.model.Manager;
import com.mph.model.Salary;

public class EmployeeController implements EmployeeInterface{
	Employee emp;
	Manager mgr;
	Salary sal;
	List<Employee> emplist=new ArrayList<Employee>();
	EmployeeDao empdao=new EmployeeDao();
	
	public List addEmployee()
	{
		emp=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno=sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename");
		String enam=sc.next();
		emp.setEname(enam);
		
		sal=new Salary();
		System.out.println("Enter basic Salary");
		//System.out.println(emp.getEid()+" "+emp.getEname());
		//System.out.println("Employee "+eno +" Successfully added");
		
		int basic=sc.nextInt();
		sal.setBasic(basic);
		System.out.println("enter Da");
		int da=sc.nextInt();
		sal.setDa(da);
		System.out.println("enter HRA");
		int hra=sc.nextInt();
		sal.setHra(hra);
		System.out.println("enter PF");
		int pf=sc.nextInt();
		sal.setPf(pf);
		
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		emp.setSalary(sal);
		
		//emplist.add(emp);	
		empdao.insertEmp(emp);
		
		//System.out.println(emp.getEid()+" "+emp.getEname());
		System.out.println("Employee "+eno+ "Successfully added");
		return emplist;
		
		
	}
	
	
	public void addManager()
	{
		mgr=new Manager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno=sc.nextInt();
		mgr.setEid(eno);
		System.out.println("Enter the Ename");
		String enam=sc.next();
		mgr.setEname(enam);
		
		sal=new Salary();
		System.out.println("Enter basic Salary");
		//System.out.println(emp.getEid()+" "+emp.getEname());
		//System.out.println("Employee "+eno +" Successfully added");
		
		int basic=sc.nextInt();
		sal.setBasic(basic);
		System.out.println("enter Da");
		int da=sc.nextInt();
		sal.setDa(da);
		System.out.println("enter HRA");
		int hra=sc.nextInt();
		sal.setHra(hra);
		System.out.println("enter PF");
		int pf=sc.nextInt();
		sal.setPf(pf);
		
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		mgr.setSalary(sal);
		System.out.println("Enter Dept:");
		String dept=sc.next();
		mgr.setDept(dept);
		System.out.println("new manager "+ enam+" added successfully  ");
	}
		
		
		//System.out.println(emp.getEid()+" "+emp.getEname());
		//System.out.println("Employee "+eno+ "Successfully added");
		
	public void viewEmployee(List elist)
	{
		//System.out.println(emp.getEid()+" "+emp.getEname());
	/*	Iterator i=elist.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}*/
		//elist.forEach(els->System.out.println(els));
		empdao.viewEmp();
		
	}
	/*
	public void inserUsingProc()
	{
		Employee e=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno=sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam=sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}*/
	
	public void rsmd()
	{
		empdao.rsmd();
	}
	
	
	public void viewManager()
	{
		System.out.println(mgr);
	}
	public void sortByName(List emplist)
	{
		Collections.sort(emplist,Employee.nameComparator);
		
		Iterator i=emplist.iterator();
		while(i.hasNext())
		{
		System.out.println(i.next());
		}
		}
	public void startwith()
	{
		Predicate<Employee> p1=emp1->emp1.getEname().startsWith("A") || emp1.getEname().startsWith("a");
		emplist.stream().filter(p1)
		.forEach(System.out::println);
	
	}
	public void SerialEg1(List<Employee> elist)
	{
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	try {
		fos=new FileOutputStream("myfile1.text");
		oos=new ObjectOutputStream(fos);
		oos.writeObject(emp);
		
		System.out.println("Data successfully serialized");
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
		try {
			fos.close();
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DeserialEg1(List<Employee> elist) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis=new FileInputStream("myfile1.text");
			ObjectInputStream ois=new ObjectInputStream(fis);
				emp=(Employee)ois.readObject();
				System.out.println(emp);
				fis.close();
				ois.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println(emp.getEid());
		System.out.println(emp.getEname());
		System.out.println(emp.getSalary());
		
	}

	@Override
	public void type_forward_only_rs()
	{
		empdao.type_forward_only_rs();
	}
	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}

	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();
		
	}


	@Override
	public void insertUsingProc() {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno=sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam=sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
		
	}
	
	public void type_scroll_sensitive_rs_update()
	{
		empdao.type_scroll_sensitive_rs_update();
	}
	public void batchUpdate()
	{
		empdao.batchUpdate();
	}
	
	
}