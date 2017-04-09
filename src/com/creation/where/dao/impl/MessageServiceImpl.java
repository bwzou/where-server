package com.creation.where.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.creation.where.dao.MessageService;
import com.creation.where.po.Message;
import com.creation.where.po.User;
import com.creation.where.util.DBHelper;

public class MessageServiceImpl implements MessageService{
	private DBHelper dbhelper = new DBHelper();

	@Override
	public List<Message> selectMessageByfriends(User user, int friendId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOneMessage(Message message) {
		// TODO Auto-generated method stub
		String sql="insert into chat(from_user_id,to_user_id,msg,voice,video,emotion,create_time,latitude,longitude) values(?,?,?,?,?,?,?,?,?)";
		int n =dbhelper.execOthers(sql,message.getFrom_user_id(), message.getTo_user_id(),message.getMsg(),message.getVideo()
				,message.getVideo(),message.getEmotion(),message.getCreate_time(),message.getLatitude(),message.getLongitude());
		dbhelper.closeAll();
		return n;
	}

	@Override
	public Message getOneMessage(String from_user_id, String to_user_id) {
		// TODO Auto-generated method stub
		String sql="select * from chat where from_user_id=? and to_user_id=? and is_read=0 order by create_time desc limit 1";
		ResultSet rst=dbhelper.execQuery(sql, from_user_id,to_user_id);
		
		String sql2="update chat set is_read=1 where msg_id=?";
		Message message=new Message();
		try {
			while(rst.next()){
				message.setMsg_id(rst.getInt("msg_id"));
				message.setFrom_user_id(rst.getInt("from_user_id"));
				message.setTo_user_id(rst.getInt("to_user_id"));
				message.setMsg(rst.getString("msg"));
				message.setEmotion(rst.getString("emotion"));
				message.setVoice(rst.getString("voice"));
				message.setVideo(rst.getString("video"));
				message.setCreate_time(rst.getTimestamp("create_time"));
				message.setLatitude(rst.getDouble("latitude"));
				message.setLongitude(rst.getDouble("longitude"));
			}
			rst.close();
			int n=dbhelper.execOthers(sql2, message.getMsg_id());
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closeAll();
		}	
		return null;
	}
	

}
