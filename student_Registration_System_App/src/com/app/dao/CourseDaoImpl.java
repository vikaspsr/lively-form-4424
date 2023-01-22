package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.exception.CouseException;
import com.app.model.StudentCourseDto;
import com.app.utility.DbUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public List<StudentCourseDto> getAllDetialOfStudentAndCouseByCourseName(String cname)throws CouseException {
		
		List<StudentCourseDto>listOStudentCourseDtos=new ArrayList<>();
		
		
		
		try(Connection conn=DbUtil.prepareConnection()) {
			          PreparedStatement ps= conn.prepareStatement("select s.roll,s.name,s.address,s.email,c.cname,c.fee,c.duration\r\n"
			          		+ "from student s INNER JOIN course c INNER JOIN student_course sc\r\n"
			          		+ "ON\r\n"
			          		+ "s.roll=sc.roll AND c.cid=sc.cid AND c.cname=?");
			          
			          ps.setString(1, cname);
		       ResultSet rs=ps.executeQuery(); 
		       
		      while (rs.next()) {
				StudentCourseDto studentCourseDto=new StudentCourseDto();
				
				studentCourseDto.setName(rs.getString("name"));
				
				studentCourseDto.setAddress(rs.getString("address"));
				studentCourseDto.setEmail(rs.getString("email"));
				studentCourseDto.setDuration(rs.getString("duration"));
				studentCourseDto.setRoll(rs.getInt("roll"));
				studentCourseDto.setFee(rs.getInt("fee"));
				
				listOStudentCourseDtos.add(studentCourseDto);
				
			}
			          
			
			
		} catch (SQLException e) {
			throw new CouseException("Plese enter valid couse name for reference refer our couse catlog");
		}
		
		
		
		
		
		
	
		return listOStudentCourseDtos;
	}

}
