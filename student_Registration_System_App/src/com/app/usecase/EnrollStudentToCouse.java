package com.app.usecase;

import java.util.Scanner;

import com.app.dao.StudentDaoImpl;
import com.app.dao.StudentdDao;
import com.app.exception.CouseException;
import com.app.exception.StudentException;
import com.app.model.Student;

public class EnrollStudentToCouse {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("======welcome to couse selection section=====");
		

		
		
		StudentdDao obj = new StudentDaoImpl();
		
		while(true) {
			System.out.println("Enter the roll");
		        int roll = Integer.valueOf(   sc.nextLine());
		        
		        System.out.println("Enter the couse id ");
		         int  cid= Integer.valueOf(sc.nextLine());
		         
		       try {
				String reString=  obj.enrollStudnentToCouse(roll, cid);
				System.out.println(reString);
			} catch (StudentException e) {
			System.out.println(e.getMessage());
			
			} catch (CouseException e) {
			System.out.println(e.getMessage());
			}
		      
		      
		        
		        System.out.println("Do you want to resister in more course?(yes/no)");
		           
		                  String res= sc.nextLine();
		                  if(res.charAt(0)=='n'||res.charAt(0)=='N') {
		                	  System.out.println("Thank you");
		                	 break;
		                  }
		}
		
		
		   
		
		                    
		
		
		
		
	}

}
