package com.edu;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Insertion_record 
{

	public static void main(String[] args) {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbd:mysql://localhost:3306/edudb";
	String un="root";
	String pass="root";
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	Scanner sc= new Scanner (System.in);
	System.out.println("enter id to insert  record");
	int id=sc.nextInt();
	String sql= "select *from login where id="+id;
	
	try
	{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,un,pass);
		st=conn.createStatement();
		rs=st.executeQuery(sql);
		if(!rs.next())
		{
			System.out.println("enter name ");
			String name=sc.next();
			String ins="insert into login values("+id+",'"+name+"')";
			int i =st.executeUpdate(ins);
			if(i>0)
			{
				System.out.println("record is insert succesfully");
				
			}
		}else
		{
			System.out.println("id already exixts choose different");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	}
}