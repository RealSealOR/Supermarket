package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.po.Provider;
import com.util.c.DBUtil;

public class ProviderDao {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static ArrayList<Provider> getAllProvider(){
		ArrayList<Provider> list = new ArrayList<Provider>();
		con = DBUtil.getDB();//调用DBUtil中的getDB方法连接数据库
		String sql="select * from provider";//创建SQL语句	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();//执行SQL语句
			while(rs.next()) {//遍历rs结果集
				Provider p = new Provider();//新建Provider模型
				p.setProvider_no(rs.getString("provider_no"));
				p.setProvider_name(rs.getString("provider_name"));
				p.setProvider_id(rs.getInt("provider_id"));
				p.setProvider_contacts(rs.getString("provider_contacts"));
				p.setProvider_describe(rs.getString("provider_describe"));
				p.setProvider_loc(rs.getString("provider_loc"));
				p.setProvider_tel(rs.getString("provider_tel"));
				list.add(p);//将
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
