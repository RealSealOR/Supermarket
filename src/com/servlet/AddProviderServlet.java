package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProviderDao;

import com.po.Provider;


/**
 * Servlet implementation class AddProviderServlet
 */
@WebServlet("/AddProviderServlet")
public class AddProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProviderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//设置编码，中文处理
		String prono=request.getParameter("proId");
		String proname=request.getParameter("proName");
		String prodesc=request.getParameter("proDesc");
		String contact=request.getParameter("contact");
		String tel=request.getParameter("phone");
		String address=request.getParameter("address");

		Provider newu = new Provider(prono,proname,prodesc,contact,tel,address);
		if(Provider.addProvider(newu)) {//添加成功
			//跳转到admin_depart_list.jsp-->直接交给DepartServlet处理省去一步点击操作
			ArrayList<Provider> arrayList = new ArrayList<Provider>();
			arrayList = ProviderDao.getAllProvider();
			request.setAttribute("pro_list", arrayList);
			response.sendRedirect(request.getContextPath()+"/ProviderServlet");			
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
