package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.po.Bill;
import com.util.c.DBUtil;

public class BillDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<Bill> getAllBill(){
		ArrayList<Bill> list = new ArrayList<Bill>();
		con = DBUtil.getDB();//����DBUtil�е�getDB�����������ݿ�
		String sql="select * from bill";//����SQL���		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();//ִ��SQL���
			while(rs.next()) {//����rs�����
				Bill b=new Bill();//�½�bill����ģ��
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
	/**
	 * ͨ����Ʒ���ƽ�ģ���в�ѯ
	 * @return arrayList
	 */
	public List<Bill> getBillByLikeName(String billProname) {
		List<Bill> arrayList = new ArrayList<Bill>();
		con = DBUtil.getDB();
		String sql = "select bill_id,bill_no,bill_proname,bill_pronum,bill_price,bill_payment,bill_prodescribe,bill_date,provider_id "
				+ " from bills"
				+ " where bill_proname like concat('%',?,'%') ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, billProname);
			rs = ps.executeQuery();
			while(rs.next()) {
				Bill b = new Bill();
				b.setBill_id(rs.getInt("bill_id"));
				b.setBill_no(rs.getString("bill_no"));
				b.setBill_proname(rs.getString("bill_proname"));
				b.setBill_pronum(rs.getString("bill_pronum"));
				b.setBill_price(rs.getString("bill_price"));
				b.setBill_payment(rs.getString("bill_payment"));
				b.setBill_prodescribe(rs.getString("bill_prodescribe"));
				b.setBill_date(rs.getString("bill_date"));
				b.setProvider_id(rs.getString("provider_id"));
				arrayList.add(b);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	/**
	 * ͨ����Ʒ���ƺ͸���״̬���Ͻ���ģ����ѯ
	 * @return arrayList
	 */
	public List<Bill> getBillByLikeNameAndPayment(String billProname,int billPayment) {
		List<Bill> arrayList = new ArrayList<Bill>();
		con = DBUtil.getDB();
		String sql = "select bill_id,bill_no,bill_proname,bill_pronum,bill_price,bill_payment,bill_prodescribe,bill_date,provider_id "
				+ " from bills"
				+ " where bill_proname like concat('%',?,'%') and bill_payment=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, billProname);
			ps.setInt(2, billPayment);
			rs = ps.executeQuery();
			while(rs.next()) {
				Bill b = new Bill();
				b.setBill_id(rs.getInt("bill_id"));
				b.setBill_no(rs.getString("bill_no"));
				b.setBill_proname(rs.getString("bill_proname"));
				b.setBill_pronum(rs.getString("bill_pronum"));
				b.setBill_price(rs.getString("bill_price"));
				b.setBill_payment(rs.getString("bill_payment"));
				b.setBill_prodescribe(rs.getString("bill_prodescribe"));
				b.setBill_date(rs.getString("bill_date"));
				b.setProvider_id(rs.getString("provider_id"));
				arrayList.add(b);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	/**
	 * ����һ�����ݵ�Bill��
	 * @param bill
	 */
	public boolean addBill(Bill bill) {
		int isInsert = 0;
		con = DBUtil.getDB();
		String sql = "insert into bills(bill_id,bill_no,bill_pronum,bill_price,bill_payment,bill_prodescribe,bill_date,provider_id)"
				+ "  values(0,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bill.getBill_no());
			ps.setString(2,bill.getBill_pronum());
			ps.setString(3, bill.getBill_price());
			ps.setString(4, bill.getBill_payment());
			ps.setString(5, bill.getBill_prodescribe());
			ps.setString(6, bill.getBill_date());
			ps.setString(7, bill.getProvider_id());
			isInsert = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (isInsert == 1) {//�ж��Ƿ����ɹ�
			return true;
		}
		return false;
	}
}
