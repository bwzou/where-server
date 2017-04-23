package com.creation.where.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creation.where.dao.FootprintService;
import com.creation.where.dao.TogetherService;
import com.creation.where.dao.impl.FootprintServiceImpl;
import com.creation.where.dao.impl.TogetherServiceImpl;
import com.creation.where.po.Footprint;
import com.creation.where.po.Param;
import com.creation.where.po.Together;
import com.creation.where.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TogetherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String option;
	private Gson gson=new Gson();

	public TogetherController() {
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
		
		String content=request.getParameter("content");
		Log.i("content为："+content);
		
		List<Param> params=gson.fromJson(content, new TypeToken<List<Param>>(){}.getType());
		option=(String)params.get(0).getValue();
		TogetherService togetherService=new TogetherServiceImpl();
		if(option.equals("insert")){
			String tmp=gson.toJson(params.get(1).getValue());
			Together together=gson.fromJson(tmp, Together.class);
			Log.i("发布一个拼途："+tmp);
			
			int n=togetherService.addOneStroke(together);
			out.write(n);
		}
	}
}
