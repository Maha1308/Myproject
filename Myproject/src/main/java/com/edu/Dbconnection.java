package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Dbconnection {
	

	public static void main(String[] args) {
		String name;
		int id;
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		name=sc.next();
		
		System.out.println("Enter id");
		id=sc.nextInt();
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb";//edudb is database name
		String un="root";
		String pa="root";
		
		try {
			//load the driver
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,un,pa);
			Statement st=conn.createStatement();
		     
			String ins="insert into login values("+id+",'"+name+"')";
			int i=st.executeUpdate(ins);
			if(i>0) {
				System.out.println("Record inserted");
			}else {
				System.out.println("Not inserted");
			}
		
	     }catch(Exception e) {
			e.printStackTrace();
		}

	}

}
