package com.edu;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteRecord 
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
	System.out.println("enter id to delete record");
	int id=sc.nextInt();
	try
	{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,un,pass);
		st=conn.createStatement();
		String sql="select*from login where id="+id;
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			String del="delete from login where id="+id;
			int i= st.executeUpdate(del);
			if(i>0)
			{
				System.out.println("record is deleted");
				
			}
		}else
		{
			System.out.println("records not exists");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	}
}