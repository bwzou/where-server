package com.creation.where.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creation.where.dao.UserService;
import com.creation.where.dao.impl.UserServiceImpl;
import com.creation.where.po.User;
import com.google.gson.Gson;
import com.creation.where.util.Log;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String option;
	private Gson gson=new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		option=request.getParameter("option");
		String phone_number = request.getParameter("phone_number");
		String password = request.getParameter("password");
		User user = new User();	
		user.setPhone_number(phone_number);
		user.setPassword(password);
		
		UserService userService=new UserServiceImpl();
		if(option.equals("login")){
			Log.i("登陆用户名："+phone_number+"密码："+password);
			
			User result = userService.userLogin(user);
			if(result==null)
				result=new User();
			String strJson = gson.toJson(result);
			out.print(strJson);
		}else if(option.equals("register")){
			String nickname = request.getParameter("nickname");
			Log.i("新用户注册："+nickname+"电话："+phone_number);
			
			user.setNickname(nickname);
			int tmp=userService.userRegister(user);
			out.print(tmp);
		}
		
	}
	
}
