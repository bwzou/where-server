package com.creation.where.dao;

import java.util.ArrayList;

import com.creation.where.po.Footprint;

public interface FootprintService {
	/**
	 * 获取周围足记
	 */
	public abstract ArrayList<Footprint> getAroundFootprint(String lat,String lon);
	
	/**
	 * 插入一条足记
	 */
	public abstract int addOneFootprint(Footprint footprint);

}
