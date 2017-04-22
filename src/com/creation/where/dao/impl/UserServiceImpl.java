package com.creation.where.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.creation.where.dao.UserService;
import com.creation.where.po.User;
import com.creation.where.util.DBHelper;
import com.creation.where.util.Log;

public class UserServiceImpl implements UserService {
	private DBHelper dbhelper = new DBHelper();

	@Override
	public User selectUserByUsername(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where phone_number=?";
		ResultSet rst=dbhelper.execQuery(sql, user.getPhone_number());
		
		User loginUser=new User();
		try {
			while(rst.next()){
				loginUser.setId(rst.getInt("user_id"));
				loginUser.setNickname(rst.getString("nickname"));
				loginUser.setPassword(rst.getString("password"));
				loginUser.setWhere_name(rst.getString("where_name"));
				loginUser.setGender(rst.getInt("gender"));
				loginUser.setPhone_number(rst.getString("phone_number"));
				loginUser.setArea(rst.getString("area"));
				loginUser.setSignature(rst.getString("signature"));
				loginUser.setReminder(rst.getString("reminder"));
				loginUser.setRemind_time_from(rst.getTimestamp("remind_time_from"));
				loginUser.setRemind_time_to(rst.getTimestamp("remind_time_to"));
			}
			rst.close();
			return loginUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where phone_number=? and password=?";
		ResultSet rst=dbhelper.execQuery(sql, user.getPhone_number(),user.getPassword());
		
		User loginUser=new User();
		try {
			while(rst.next()){
				loginUser.setId(rst.getInt("user_id"));
				loginUser.setNickname(rst.getString("nickname"));
				loginUser.setPassword(rst.getString("password"));
				loginUser.setWhere_name(rst.getString("where_name"));
				loginUser.setGender(rst.getInt("gender"));
				loginUser.setPhone_number(rst.getString("phone_number"));
				loginUser.setArea(rst.getString("area"));
				loginUser.setSignature(rst.getString("signature"));
				loginUser.setReminder(rst.getString("reminder"));
				loginUser.setRemind_time_from(rst.getTimestamp("remind_time_from"));
				loginUser.setRemind_time_to(rst.getTimestamp("remind_time_to"));
			}
			rst.close();
			return loginUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closeAll();
		}	
		return null;
	}
	
	@Override
	public int userRegister(User user) {
		// TODO Auto-generated method stub
		User user2=selectUserByUsername(user); 
		if(user2.getPhone_number()!=null)
			return -2;    //该号码已被注册
		
		String sql="insert into user(nickname,phone_number,password) values(?,?,?)";
		int n =dbhelper.execOthers(sql,user.getNickname(), user.getPhone_number(),user.getPassword());
		dbhelper.closeAll();
		return n;
	}


	@Override
	public List<User> selectFriends(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOneUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
