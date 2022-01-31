package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.po.Bill;
import com.po.Provider;
import com.po.User;
import com.util.c.DBUtil;


public class SelectDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<Bill> selectBillName(String name, String isPay) {
		con = DBUtil.getDB();
		String sql="select * from bill where bill_proname=? and bill_payment=?";
		ArrayList<Bill> list = new ArrayList<Bill>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, isPay);
			rs = ps.executeQuery();
			while(rs.next()) {
				Bill b=new Bill();//新建bill订单模型
				b.setBill_id(rs.getInt("bill_id"));
				b.setBill_no(rs.getString("bill_no"));
				b.setBill_proname(rs.getString("bill_proname"));
				b.setBill_pronum(rs.getString("bill_pronum"));
				b.setBill_price(rs.getString("bill_price"));
				b.setBill_payment(rs.getString("bill_payment"));
				b.setBill_prodescribe(rs.getString("bill_prodescribe"));
				b.setBill_date(rs.getString("bill_date"));
				b.setProvider_id(rs.getString("provider_id"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Provider> selectProviderName(String name, String desc) {
		// TODO Auto-generated method stub
		con = DBUtil.getDB();
		String sql="select * from provider where provider_name like concat('%',?,'%')  and provider_describe like concat('%',?,'%') ";		
		ArrayList<Provider> list = new ArrayList<Provider>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, desc);
			rs = ps.executeQuery();
			while(rs.next()) {
				Provider p = new Provider();//新建Provider模型
				p.setProvider_no(rs.getString("provider_no"));
				p.setProvider_name(rs.getString("provider_name"));
				p.setProvider_id(rs.getInt("provider_id"));
				p.setProvider_contacts(rs.getString("provider_contacts"));
				p.setProvider_describe(rs.getString("provider_describe"));
				p.setProvider_loc(rs.getString("provider_loc"));
				p.setProvider_tel(rs.getString("provider_tel"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User> selectUserName(String name) {
		// TODO Auto-generated method stub
		con = DBUtil.getDB();
		String sql="select * from user where user_name=?";
		ArrayList<User> list = new ArrayList<User>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
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
