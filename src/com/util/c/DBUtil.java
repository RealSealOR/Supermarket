package com.util.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static Connection con;
	private PreparedStatement pstmt;
	
	public static Connection getDB() {
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			String url = "jdbc:mysql://localhost:3306/supermarket?characterEncoding=utf-8";			
			con = DriverManager.getConnection(url,"root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	private void setParams(String sql,String[] params) {
		if(params!=null) {
			for(int i = 0;i<params.length;i++) {
				try {
					pstmt.setString(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void close() {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int executeUpdate(String sql, String[] params) {
		// TODO Auto-generated method stub
		int result = 0;
		getDB();//连接数据库
		try {
			pstmt = con.prepareStatement(sql);
			setParams(sql,params);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return result;
	}
	public ResultSet executeQuery(String sql, String[] parames) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		getDB();//连接数据库
		try {
			pstmt = con.prepareStatement(sql);
			setParams(sql,parames);
			//给？赋值
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
