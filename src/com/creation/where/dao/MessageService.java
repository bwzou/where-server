package com.creation.where.dao;

import java.util.List;

import com.creation.where.po.Message;
import com.creation.where.po.User;

public interface MessageService {
	/**
	 * 根据用户和聊天对象查找聊天内容
	 */
	public abstract List<Message> selectMessageByfriends(User user,int friendId);
	
	/**
	 * 新增一条信息
	 */
	public abstract int addOneMessage(Message chat);
	
	/**
	 * 获取一条消息
	 */
	public abstract Message getOneMessage(String from_user_id,String to_user_id);
	
}
