package com.app.dao;

import java.util.List;

import com.app.exception.CouseException;
import com.app.model.StudentCourseDto;

public interface CourseDao {

	
	
	public List<StudentCourseDto> getAllDetialOfStudentAndCouseByCourseName(String cname)throws CouseException;
	
	
	
	
}
