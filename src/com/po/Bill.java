package com.po;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.util.c.DBUtil;

public class Bill {
	private int bill_id;
	private String bill_no;
	private String bill_proname;
	private String bill_pronum;
	private String bill_price;
	private String bill_payment;
	private String bill_prodescribe;
	private String bill_date;
	private String provider_id;
	
	public Bill() {
		super();
	}
	public Bill(int bill_id, String bill_no, String bill_proname, String bill_pronum, String bill_price, String bill_payment,
			String bill_prodescribe, String bill_date, String provider_id) {
		super();
		this.bill_id = bill_id;
		this.bill_no = bill_no;
		this.bill_proname = bill_proname;
		this.bill_pronum = bill_pronum;
		this.bill_price = bill_price;
		this.bill_payment = bill_payment;
		this.bill_prodescribe = bill_prodescribe;
		this.bill_date = bill_date;
		this.provider_id = provider_id;
	}
	public Bill(String no,String name,String num, String money, String discription,String isPay,String proid) {
		// TODO Auto-generated constructor stub
		super();
		this.bill_no=no;
		this.bill_proname=name;
		this.bill_pronum=num;
		this.bill_price=money;
		this.bill_prodescribe=discription;
		this.bill_payment=isPay;
		this.provider_id=proid;
	}
	public Bill(String no,String name, String money,String num, String discription,String isPay,String proid,int id) {
		// TODO Auto-generated constructor stub
		super();
		this.bill_no=no;
		this.bill_proname=name;
		this.bill_pronum=num;
		this.bill_price=money;
		this.bill_prodescribe=discription;
		this.bill_payment=isPay;
		this.provider_id=proid;
		this.bill_id=id;
	}
	
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}
	public String getBill_proname() {
		return bill_proname;
	}
	public void setBill_proname(String bill_proname) {
		this.bill_proname = bill_proname;
	}
	public String getBill_pronum() {
		return bill_pronum;
	}
	public void setBill_pronum(String bill_pronum) {
		this.bill_pronum = bill_pronum;
	}
	public String getBill_price() {
		return bill_price;
	}
	public void setBill_price(String bill_price) {
		this.bill_price = bill_price;
	}
	public String getBill_payment() {
		return bill_payment;
	}
	public void setBill_payment(String bill_payment) {
		this.bill_payment = bill_payment;
	}
	public String getBill_prodescribe() {
		return bill_prodescribe;
	}
	public void setBill_prodescribe(String bill_prodescribe) {
		this.bill_prodescribe = bill_prodescribe;
	}
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public String getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public static int deleteBill(String id) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="delete from Bill where bill_id=?";
		String params[]= {id};
		int n=db.executeUpdate(sql, params);

		return n;
	}
	public static Bill getBillByName(String name) {
		// TODO Auto-generated method stub
		Bill b=null;
		String sql = "select * from bill where bill_proname=?";
		String params[]= {name};
		DBUtil db=new DBUtil();
		ResultSet rs = db.executeQuery(sql, params);
		try {
			if(rs.next()) {
		     //读每个字段封装到bill对象里
				b= new Bill();
				b.setBill_no(rs.getString("bill_no"));
				b.setBill_proname(rs.getString("bill_proname"));
				b.setBill_pronum(rs.getString("bill_pronum"));
				b.setBill_price(rs.getString("bill_price"));
				b.setBill_prodescribe(rs.getString("bill_prodescribe"));
				b.setBill_payment(rs.getString("bill_payment"));
				b.setProvider_id(rs.getString("provider_id"));
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static int addBill(Bill newd) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="insert into bill(bill_no,bill_proname,bill_pronum,bill_price,bill_prodescribe,bill_payment,provider_id) values(?,?,?,?,?,?,?)";
		String params[]= {
				newd.getBill_no(),
				newd.getBill_proname(),	
				newd.getBill_pronum(),
				newd.getBill_price(),				
				newd.getBill_prodescribe(),
				newd.getBill_payment(),
				newd.getProvider_id()
				};
		int n = db.executeUpdate(sql, params);
				
		return n;
	}
	public static Bill getDepartById(String id) {
		// TODO Auto-generated method stub
		Bill d = null;
		DBUtil db=new DBUtil();
		String sql="select * from bill where bill_id=?";
		String parames[]= {id};
		ResultSet rs = db.executeQuery(sql, parames);
		try {
			if(rs.next()) {
		     //读每个字段封装到bill对象里
				d= new Bill();
				d.setBill_id(rs.getInt("bill_id"));
				d.setBill_proname(rs.getString("bill_proname"));
				d.setBill_price(rs.getString("bill_price"));
				d.setBill_prodescribe(rs.getString("bill_prodescribe"));
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public int updateBill(Bill b) {
		// TODO Auto-generated method stub
		int rs=0;
		DBUtil db=new DBUtil();
		
		// 执行SQL语句，得到结果集，结果集放到ResultSet对象中
		String sql="update Bill set bill_proname=?,bill_pronum=?,bill_price=?,bill_prodescribe=?,bill_payment=?,provider_id=? where bill_id=?";
		String ps[]= {b.getBill_proname(),b.getBill_pronum(),b.getBill_price(),b.getBill_prodescribe(),b.getBill_payment(),b.getProvider_id(),b.getBill_id()+""};
		rs=db.executeUpdate(sql,ps);
		    return rs;
	}

}
