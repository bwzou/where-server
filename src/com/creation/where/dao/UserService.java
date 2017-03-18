package com.creation.where.dao;

import java.util.List;

import com.creation.where.po.User;

public interface UserService {
	/**
	 * 根据用户名查找用户
	 */
	public abstract User selectUserByUsername(User user);
	
	/**
	 * 根据用户名和密码查找用户
	 */
	public abstract User userLogin(User user);
	
	/**
	 * 查询用户好友
	 */
	public abstract List<User> selectFriends(User user);
	
	/**
	 * 修改用户信息
	 */
	public abstract boolean changeUserInfo(User user);
	
	/**
	 * 删除一个用户
	 */
	public abstract boolean deleteOneUser(User user);
	
	/**
	 * 新用户注册
	 * 返回0代表成功，-2代表该号码已注册，-1代表异常
	 */
	public abstract int userRegister(User user);
}
