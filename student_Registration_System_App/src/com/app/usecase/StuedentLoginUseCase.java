package com.app.usecase;

import java.util.Scanner;

import com.app.dao.StudentDaoImpl;
import com.app.dao.StudentdDao;
import com.app.exception.StudentException;
import com.app.model.Student;

public class StuedentLoginUseCase {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		StudentdDao objOfStudentDao=new StudentDaoImpl();
		
		System.out.println("welcome to student loging portal");
		System.out.println("Please enter the Register email id");
		       String username=sc.nextLine();
		       
		 System.out.println("Please enter the password");      
		       String password =sc.nextLine();
		       
		       try {
			   Student student=	objOfStudentDao.loginStudent(username, password);
			  System.out.println("Welcome "+student.getName()+"in  studnet section.");
			} catch (StudentException e) {
				
				System.out.println(e.getMessage());
			}
		
		
		
		
	}
}
