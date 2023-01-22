package com.app.usecase;

import java.sql.Connection;

import com.app.utility.DbUtil;

public class CheckConnecton {

	
	public static void main(String[] args) {
		
		
		
	Connection connection=	DbUtil.prepareConnection();
	
	System.out.println(connection);
	}
	
	
}
