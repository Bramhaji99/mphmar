package com.mph.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.exception.EmployeeNotFoundException;
import com.mph.model.Employee;


public class MainClass {

	public static void main(String[] args) throws IOException{
		EmployeeInterface ec=new EmployeeController();
		List<Employee> elist=null;
		
		Scanner sc=new Scanner(System.in);
		
		String input=null;
		System.out.println("Enter your username");
		String un=sc.next();
		System.out.println("Enter your password");
		String pw=sc.next();
		
		try {

			System.out.println("Please wait");
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		
		try {
			BiPredicate<String,String> pred=(una,pwd)->una.equals("ab") && pwd.equals("abc");
			//System.out.println(pred.test(una,pwd));
			
		if(pred.test(un,pw))
		{
			System.out.println("welcome");
			
	
		do {
			System.out.println("Enter your Choice");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Add Manager");
			System.out.println("4.View Manager");
			System.out.println("5.Sort");
			System.out.println("6.Start with a (or) A");
			System.out.println("7.Serialize data");
			System.out.println("8.Deserialize data");
			System.out.println("9.Procedure Insert");
			System.out.println("10.Get ResultSet MetaData Info");
			System.out.println("11.RS Forward only");
			System.out.println("12.RS scroll insensitive");
			System.out.println("13.RS scroll sensitive");
			System.out.println("14.RS scroll update");
			System.out.println("15.Batch Update");
			
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:{
				elist=ec.addEmployee();
				break;
			}
			case 2:
			{
				ec.viewEmployee(elist);
				break;
				
			}
			case 3:
			{
				ec.addManager();
				break;
				
			}
			case 4:
			{
				ec.viewManager();
				break;
				
			}
			case 5:
			{
				ec.sortByName(elist);
				break;
			}
			case 6:
			{
				ec.startwith();
				break;
			}
			case 7:
			{
				ec.SerialEg1(elist);
				break;
			}
			case 8:
			{
				ec.DeserialEg1(elist);
				break;
			}
			case 9:
			{
				ec.insertUsingProc();
				break;
			}
			case 10:
			{
				ec.rsmd();
				break;
			}
			case 11:
			{
				ec.type_forward_only_rs();
				break;
			}
			case 12:
			{
				ec.type_scroll_insensitive_rs();
				break;
			}
			case 13:
			{
				ec.type_scroll_sensitive_rs_insert();
				break;
			}
			case 14:
			{
				ec.type_scroll_sensitive_rs_update();
				break;
			}
			case 15:
			{
				ec.batchUpdate();
				break;
			}
			default:{
				System.out.println("Enter Right choice");
			}
		}
			System.out.println("Do you want to continue? Y or y for yes ");
			input=sc.next();

	}while(input.equals("Y") || input.equals("y"));
		}
		else
		{
			//System.out.println("User not found Exception");
			throw new EmployeeNotFoundException();
		}
		}
		catch(EmployeeNotFoundException enfe)
		{
			System.out.println(enfe);
			
		}		
		catch(Exception e)
		{
			System.out.println("Exception Raised");
			e.printStackTrace();
		}
		finally {
		System.out.println("System Exited..args Thanks for using our system");
		System.exit(0);
		}
	}
}
