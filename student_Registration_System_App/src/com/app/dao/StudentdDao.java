package com.app.dao;

import com.app.exception.CouseException;
import com.app.exception.StudentException;
import com.app.model.Student;
import com.mysql.cj.util.DnsSrv.SrvRecord;

public interface StudentdDao {

	public String registerStudent(Student s)throws StudentException;
	public Student loginStudent(String userName,String password)throws StudentException;
	public String enrollStudnentToCouse(int roll,int cid) throws StudentException,CouseException;
	
	
}
