package com.po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.c.DBUtil;

public class User {
	private int user_id;
	private String user_name;
	private String user_password;
	private int user_sex;
	private int user_age;
	private String user_tel;
	private String user_loc;
	private int user_role;
	public User(int uid, String uname, String password, int sex, int age, String tel,String loc, int auth) {
		// TODO Auto-generated constructor stub
		super();
		this.user_id=uid;
		this.user_name=uname;
		this.user_password=password;
		this.user_sex=sex;
		this.user_age=age;
		this.user_tel=tel;
		this.user_loc=loc;
		this.user_role=auth;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_loc() {
		return user_loc;
	}
	public void setUser_loc(String user_loc) {
		this.user_loc = user_loc;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}
	public static User getUserByName(String uname) {
		// TODO Auto-generated method stub		
		User user = new User();
		String sql="select * from user where user_name=?";
		String params[]= {uname};
		DBUtil db=new DBUtil();
		ResultSet rs = db.executeQuery(sql, params);
		try {
			
			if(rs.next()) {
				
				user.setUser_age(rs.getInt("user_age"));
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_loc(rs.getString("user_loc"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_role(rs.getInt("user_role"));
				user.setUser_sex(rs.getInt("user_sex"));
				user.setUser_tel(rs.getString("user_tel"));
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	static Connection con;
	static PreparedStatement ps;
	public static boolean addUser(User newu) {
		// TODO Auto-generated method stub
		
		int isInsert = 0;
		con = DBUtil.getDB();
		String sql = "insert into User(user_id,user_name,user_password,user_sex,user_age,user_tel,user_loc,user_role)"
				+ "  values(?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,newu.getUser_id());
			ps.setString(2, newu.getUser_name());
			ps.setString(3, newu.getUser_password());
			ps.setInt(4, newu.getUser_sex());
			ps.setInt(5, newu.getUser_age());
			ps.setString(6, newu.getUser_tel());
			ps.setString(7,newu.getUser_loc());
			ps.setInt(8, newu.getUser_role());
			isInsert = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (isInsert == 1) {
			return true;
		}
		return false;
	
	}
	public static int deleteUser(String id) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="delete from User where user_id=?";
		String params[]= {id};
		int n=db.executeUpdate(sql, params);

		return n;
	}
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		int rs=0;
		DBUtil db=new DBUtil();
		
		// 执行SQL语句，得到结果集，结果集放到ResultSet对象中
		String sql="update user set user_name=?,user_password=?,user_sex=?,user_age=?,user_tel=?,user_loc=?,user_role=? where user_id=?";
		String ps[]= {u.getUser_name(),u.getUser_password(),u.getUser_sex()+"",u.getUser_age()+"",u.getUser_tel(),u.getUser_loc(),u.getUser_role()+"",u.getUser_id()+""};
		rs=db.executeUpdate(sql,ps);
		    return rs;
	}
	
}
