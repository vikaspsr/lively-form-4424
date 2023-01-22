package com.app.usecase;

import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

import com.app.dao.CourseDao;
import com.app.dao.CourseDaoImpl;
import com.app.exception.CouseException;
import com.app.model.StudentCourseDto;

public class GetAllStudentDetailByCouseName {

	public static void main(String[] args) {
		
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the couse name to get detail of Student and  couse ");
		String cnam=sc.nextLine();
		
		CourseDao obj=new CourseDaoImpl();
		try {
		List<StudentCourseDto>list=	obj.getAllDetialOfStudentAndCouseByCourseName(cnam);
		if(list.size()==0) {
			System.out.println("Enter valid course detail");
		}else {
			list.forEach(el->System.out.println(el));
		}
		
		
		
		} catch (CouseException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
}
