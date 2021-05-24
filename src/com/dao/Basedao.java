package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Basedao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://47.100.71.44:3306/tms_jiwei";
	static final String USER = "root";
    static final String PASS = "123456";
    
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getconn(){
		Connection conn=null;
		// test update 20200413
		 try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeall(ResultSet rs,Statement ps,Connection conn){
			try {
				if(rs!=null)
				   rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static int exectuIUD(String sql,Object[] params){
		int count=0;
		  Connection conn=Basedao.getconn();
		  PreparedStatement ps=null;
		  try {
			ps=conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			Basedao.closeall(null, ps, conn);
		} 
		return count;
	}
}
