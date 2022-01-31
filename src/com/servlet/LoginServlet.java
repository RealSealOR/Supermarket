package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取页面的登录名和密码
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		
		//身份验证
		UserDao ud = new UserDao();
		if(ud.checkUser(name, pass)) {
			//登录成功
			request.getSession().setAttribute("logUser", name);
			response.sendRedirect("admin_index.jsp");
		}else {
			//登录失败
			response.sendRedirect("login.jsp");
		}
		
		
	}
}
