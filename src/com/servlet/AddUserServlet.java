package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.po.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		String age=request.getParameter("age");
		String tel=request.getParameter("mobile");
		String loc=request.getParameter("address");
		String auth=request.getParameter("auth");

		User newu = new User(Integer.parseInt(uid),uname,password,Integer.parseInt(sex),Integer.parseInt(age),tel,loc,Integer.parseInt(auth));
		if(User.addUser(newu)) {//添加成功
			//跳转到admin_depart_list.jsp-->直接交给DepartServlet处理省去一步点击操作
			ArrayList<User> arrayList = new ArrayList<User>();
			UserDao userDao=new UserDao();
			arrayList = userDao.getAllUsers();
			request.setAttribute("user_list", arrayList);
			response.sendRedirect(request.getContextPath()+"/UserServlet");			
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
