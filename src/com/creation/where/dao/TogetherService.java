package com.creation.where.dao;

import java.util.ArrayList;

import com.creation.where.po.Together;

public interface TogetherService {
	/**
	 * 发布一个行程
	 */
	public abstract int addOneStroke(Together together);
	
	/**
	 * 查询行程
	 */
	public abstract ArrayList<Together> selectTogethers(Together together,Object ...objects);

}
