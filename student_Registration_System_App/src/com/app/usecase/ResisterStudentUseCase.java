package com.app.usecase;

import java.util.Scanner;

import com.app.dao.StudentDaoImpl;
import com.app.dao.StudentdDao;
import com.app.exception.StudentException;
import com.app.model.Student;

public class ResisterStudentUseCase {

	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to the student Registration protal ");
		System.out.println("Enter the student detial");
		
		StudentdDao obj = new StudentDaoImpl();
		
		while(true) {
			System.out.println("Enter the student Name");
		        String name =    sc.nextLine();
		        
		        System.out.println("Enter the student address ");
		         String address= sc.nextLine();
		         System.out.println("Enter the student email");
		                 String emil= sc.nextLine();
		         System.out.println("Enter the student password");
		         String password =sc.nextLine();
		         
		        Student student = new Student();
		        student.setName(name);
		        student.setAddress(address);
		        student.setEmail(emil);
		        student.setPassword(password);
		        
		        try {
					String s=obj.registerStudent(student);
					System.out.println(s);
				} catch (StudentException e) {
					System.out.println(e.getMessage());
				}
		        
		        System.out.println("Do you want to resister more student?(yes/no)");
		           
		                  String res= sc.nextLine();
		                  if(res.charAt(0)=='n'||res.charAt(0)=='N') {
		                	  System.out.println("Thank you for the Resistration..");
		                	 break;
		                  }
		}
		
		
		
	}
	
	
	
	
}
