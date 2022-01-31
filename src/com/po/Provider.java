package com.po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.c.DBUtil;

public class Provider {
	private int provider_id;
	private String provider_no;	
	private String provider_name;
	private String provider_describe;
	private String provider_contacts;
	private String provider_tel;
	private String provider_loc;
	public Provider(String prono, String proname, String prodesc, String contact, String tel, String address) {
		// TODO Auto-generated constructor stub
		super();
		this.provider_no = prono;
		this.provider_name = proname;
		this.provider_describe = prodesc;
		this.provider_contacts = contact;
		this.provider_tel = tel;
		this.provider_loc = address;
	}
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
	public String getProvider_no() {
		return provider_no;
	}
	public void setProvider_no(String provider_no) {
		this.provider_no = provider_no;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getProvider_describe() {
		return provider_describe;
	}
	public void setProvider_describe(String provider_describe) {
		this.provider_describe = provider_describe;
	}
	public String getProvider_contacts() {
		return provider_contacts;
	}
	public void setProvider_contacts(String provider_contacts) {
		this.provider_contacts = provider_contacts;
	}
	public String getProvider_tel() {
		return provider_tel;
	}
	public void setProvider_tel(String provider_tel) {
		this.provider_tel = provider_tel;
	}
	public String getProvider_loc() {
		return provider_loc;
	}
	public void setProvider_loc(String provider_loc) {
		this.provider_loc = provider_loc;
	}
	public static int deleteProvider(String id) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="delete from Provider where provider_id=?";
		String params[]= {id};
		int n=db.executeUpdate(sql, params);

		return n;
	}
	static Connection con;
	static PreparedStatement ps;
	public static boolean addProvider(Provider newu) {
		// TODO Auto-generated method stub
		int isInsert = 0;
		con = DBUtil.getDB();
		String sql = "insert into Provider(provider_no,provider_name,provider_describe,provider_contacts,provider_tel,provider_loc)"
				+ "  values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,newu.getProvider_no());
			ps.setString(2, newu.getProvider_name());
			ps.setString(3, newu.getProvider_describe());
			ps.setString(4, newu.getProvider_contacts());
			ps.setString(5, newu.getProvider_tel());
			ps.setString(6, newu.getProvider_loc());
			isInsert = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (isInsert == 1) {
			return true;
		}
		return false;
	}

	public int updateProvider(Provider p) {
		// TODO Auto-generated method stub
		int rs=0;
		DBUtil db=new DBUtil();
		
		// 执行SQL语句，得到结果集，结果集放到ResultSet对象中
		String sql="update Provider set provider_name=?,provider_describe=?,provider_contacts=?,provider_tel=?,provider_loc=? where provider_id=?";
		String ps[]= {p.getProvider_name(),p.getProvider_describe(),p.getProvider_contacts(),p.getProvider_tel(),p.getProvider_loc(),p.getProvider_id()+""};
		rs=db.executeUpdate(sql,ps);
		    return rs;
	}
	

}
