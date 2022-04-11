package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateTable {

	public static void main(String[] args) {
		String mytable="create table cludemp(cid int(4) primary key, cname varchar(20) not null)";
		//connection code
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3307/myproject";
		String un="root";
		String pswd="root";
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,un,pswd);
			Statement st=conn.createStatement();
			st.execute(mytable);
		}
		catch(Exception e)
		{e.printStackTrace();
	}

}
}