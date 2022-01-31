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
		con = DBUtil.getDB();//����DBUtil�е�getDB�����������ݿ�
		String sql="select * from provider";//����SQL���	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();//ִ��SQL���
			while(rs.next()) {//����rs�����
				Provider p = new Provider();//�½�Providerģ��
				p.setProvider_no(rs.getString("provider_no"));
				p.setProvider_name(rs.getString("provider_name"));
				p.setProvider_id(rs.getInt("provider_id"));
				p.setProvider_contacts(rs.getString("provider_contacts"));
				p.setProvider_describe(rs.getString("provider_describe"));
				p.setProvider_loc(rs.getString("provider_loc"));
				p.setProvider_tel(rs.getString("provider_tel"));
				list.add(p);//��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
