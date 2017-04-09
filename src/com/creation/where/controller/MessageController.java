package com.creation.where.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creation.where.dao.MessageService;
import com.creation.where.dao.impl.MessageServiceImpl;
import com.creation.where.po.Message;
import com.creation.where.po.Param;
import com.creation.where.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class MessageController
 */
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String option;
	private Gson gson=new Gson();
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public MessageController() {
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
		Log.i("id为："+content);
		
		List<Param> params=gson.fromJson(content, new TypeToken<List<Param>>(){}.getType());
		option=(String)params.get(0).getValue();
		MessageService messageService=new MessageServiceImpl(); 
		if(option.equals("insert")){
			String tmp=gson.toJson(params.get(1).getValue());
			Message message=gson.fromJson(tmp, Message.class);
			Log.i("content为："+message.getFrom_user_id()+"的用户给id为："+message.getTo_user_id()+"的用户发送内容： "+message.getMsg());
			
			int n=messageService.addOneMessage(message);
			out.write(n);
		}else if(option.equals("selectOne")){
			String tmp=gson.toJson(params.get(1).getValue());
			Message message=gson.fromJson(tmp, Message.class);
			Log.i("查询一条未读记录："+"From_user_id为："+message.getFrom_user_id()+"To_user_id为："+message.getTo_user_id());
			
			Message message2=messageService.getOneMessage(message.getFrom_user_id()+"", message.getTo_user_id()+"");
			String msg=gson.toJson(message2);
			out.write(msg);
		}
	}

}
