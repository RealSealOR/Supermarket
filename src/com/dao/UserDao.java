package com.dao;
import java.sql.*;
import java.util.ArrayList;

import com.po.User;
import com.util.c.DBUtil;
public class UserDao {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public boolean checkUser(String name,String pass) {
		con = DBUtil.getDB();
		String sql="select user_password from user where user_name=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("user_password").equals(pass))
					return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public ArrayList<User> getAllUsers(){
		ArrayList<User> list = new ArrayList<User>();
		con = DBUtil.getDB();
		String sql="select * from user";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUser_age(rs.getInt("user_age"));
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_loc(rs.getString("user_loc"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_role(rs.getInt("user_role"));
				user.setUser_sex(rs.getInt("user_sex"));
				user.setUser_tel(rs.getString("user_tel"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
