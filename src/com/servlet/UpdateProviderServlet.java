package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Provider;

/**
 * Servlet implementation class UpdateProviderServlet
 */
@WebServlet("/UpdateProviderServlet")
public class UpdateProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProviderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String prono=request.getParameter("proId");
		String proname=request.getParameter("proName");
		String prodesc=request.getParameter("proDesc");
		String contact=request.getParameter("contact");
		String tel=request.getParameter("phone");
		String address=request.getParameter("address");
		
		Provider p=new Provider();
		p.setProvider_id(Integer.parseInt(prono));
		p.setProvider_name(proname);
		p.setProvider_describe(prodesc);
		p.setProvider_contacts(contact);
		p.setProvider_tel(tel);
		p.setProvider_loc(address);
		
		Provider pdao=new Provider();
		int n=pdao.updateProvider(p);
		if(n>0) {
			response.sendRedirect("ProviderServlet");
		}
		else
		{
			System.out.println("�޸�ʧ��");
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
