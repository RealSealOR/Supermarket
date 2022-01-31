package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//设置编码，中文处理
		String uid=request.getParameter("userId");
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");

		String tel=request.getParameter("mobile");
		String loc=request.getParameter("address");
		String auth=request.getParameter("auth");
		
		User u=new User();
		u.setUser_id(Integer.parseInt(uid));
		u.setUser_name(uname);
		u.setUser_password(password);
		u.setUser_sex(Integer.parseInt(sex));
		u.setUser_tel(tel);
		u.setUser_loc(loc);
		u.setUser_role(Integer.parseInt(auth));
		
		User udao=new User();
		int n=udao.updateUser(u);
		if(n>0)
		{
			response.sendRedirect("UserServlet");
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
