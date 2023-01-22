package com.app.dao;

import java.security.KeyStore.TrustedCertificateEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.exception.CouseException;
import com.app.exception.StudentException;
import com.app.model.Student;
import com.app.utility.DbUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class StudentDaoImpl implements StudentdDao{

	@Override
	public String registerStudent(Student s) throws StudentException {
	
		String res = null;
		
		
		try(  Connection conn=DbUtil.prepareConnection()) {
			
			PreparedStatement ps=conn.prepareStatement(" insert into student(name,address,email,password) values(?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			
			int row=ps.executeUpdate();
			if(row>0) {
				res=s.getName()+" Student is successfuly register";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
		return res;
		
	}

	@Override
	public Student loginStudent(String userName, String password) throws StudentException {
		
		Student student =null;
		try(Connection conn=DbUtil.prepareConnection()) {
			
		PreparedStatement ps	=conn.prepareStatement("select * from student where email=? AND password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
			int roll=	rs.getInt("roll");
		    String name  =  rs.getString("name");
		    String email= rs.getString("email");
		    String  address =  rs.getString("address");
		    String pwd= rs.getString("password");
		    student = new Student();
		    student.setName(name);
		    student.setRoll(roll);
		    student.setAddress(address);
		    student.setEmail(email);
		    student.setPassword(password);
		    
		    
			}else {
				throw new StudentException("Please Inter valid userName and password  or Register the student First on portals " );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException("Invalid credencial");
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	return student;	
	}

	@Override
	public String enrollStudnentToCouse(int roll,int cid) throws StudentException, CouseException {
		String res="Enter the valid detail of student and couse id for course id refer our couse catlog";
		
		
		try (Connection conn=DbUtil.prepareConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			
			
		                  ResultSet rs= ps.executeQuery();    
		                  if(rs.next()) {
		               PreparedStatement 	 psc= conn.prepareStatement("select * from course where cid=?");
		               psc.setInt(1, cid);
		               
		                ResultSet   rsc=  psc.executeQuery();
		                
		                if(rsc.next()) {
		                	
		                	PreparedStatement scps=conn.prepareStatement("insert into student_course values(?,?)");
		                	scps.setInt(1, roll);
		                	scps.setInt(2, cid);
		                	
		                	   int row =scps.executeUpdate();
		                	   
		                	   if(row>0) {
		                		   System.out.println(rs.getString("name")+" is sucess fully inrolled in " +rsc.getString("cname"));
		                	   }
		                	
		                }else {
							throw new CouseException("Please Enter valid couse id ");
						}
		                
		               
		                  }
		                        
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
			// TODO: handle exception
		}
		
		
		
		
		
		
	return res;
	}

	
	
	
	
	
}
