package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Bill;

/**
 * Servlet implementation class AddBillServlet
 */
@WebServlet("/AddBillServlet")
public class AddBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//���ñ��룬���Ĵ���
		String no=request.getParameter("bill_no");
		String name=request.getParameter("bill_name");
		String num=request.getParameter("num");
		String money=request.getParameter("money");
		String discription=request.getParameter("discription");
		String isPay=request.getParameter("isPay");
		String proid=request.getParameter("proid");
		System.out.print(no);
		Bill b=Bill.getBillByName(name);
		//��ѯ��Ϣ�Ƿ����
		if(b==null) {//��Ϣ������
			Bill newd = new Bill(no,name,num,money,discription,isPay,proid);
			int n = Bill.addBill(newd);
			if(n>0) {//��ӳɹ�
				//��ת��admin_depart_list.jsp-->ֱ�ӽ���DepartServlet����ʡȥһ���������
				response.sendRedirect(request.getContextPath()+"/BillServlet");			
			}
		}
		else {
			response.sendRedirect("modify.jsp?error=ok");
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
