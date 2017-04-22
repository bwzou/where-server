package com.creation.where.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creation.where.dao.FootprintService;
import com.creation.where.dao.impl.FootprintServiceImpl;
import com.creation.where.po.Footprint;
import com.creation.where.po.Message;
import com.creation.where.po.Param;
import com.creation.where.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FootprintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String option;
	private Gson gson=new Gson();
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public FootprintController() {
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
		FootprintService footprintService=new FootprintServiceImpl();
		if(option.equals("getaround")){
			String latitude=(double)params.get(1).getValue()+"";
			String longitude=(double)params.get(2).getValue()+"";
			Log.i("查询所有周边维度："+latitude+"经度"+longitude+"足记");
			
			ArrayList<Footprint> footprints=footprintService.getAroundFootprint(latitude, longitude);
			String msg=gson.toJson(footprints);
			out.write(msg);
		}else if(option.equals("insert")){
			String tmp=gson.toJson(params.get(1).getValue());
			Footprint footprint=gson.fromJson(tmp, Footprint.class);
			Log.i("插入一个足记："+tmp);
			
			int n=footprintService.addOneFootprint(footprint);
			out.write(n);
		}
	}
	
}
