package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Bill;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateBillServlet")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("bill_id");
		String name=request.getParameter("bill_name");
		String num=request.getParameter("bill_num");
		String money=request.getParameter("money");
		String payStatus=request.getParameter("payStatus");
		String desc=request.getParameter("desc");
		String proid=request.getParameter("proid");
		
		
		Bill b=new Bill();//新建bill订单模型
		b.setBill_id(Integer.parseInt(id));
		b.setBill_proname(name);
		b.setBill_pronum(num);
		b.setBill_price(money);
		b.setBill_payment(payStatus);
		b.setBill_prodescribe(desc);
		b.setProvider_id(proid);
		
		Bill bdao=new Bill();
		int n=bdao.updateBill(b);
		if(n>0) {
			response.sendRedirect("BillServlet");
		}
		else
		{
			System.out.println("修改失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
