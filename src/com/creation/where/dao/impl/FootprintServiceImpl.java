package com.creation.where.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creation.where.dao.FootprintService;
import com.creation.where.po.Footprint;
import com.creation.where.util.DBHelper;

public class FootprintServiceImpl implements FootprintService{
	private DBHelper dbhelper = new DBHelper();

	@Override
	public ArrayList<Footprint> getAroundFootprint(String lat,String lon) {
		// TODO Auto-generated method stub
		String sql="select * from footprint where latitude > ?-0.05 and latitude < ?+0.05 and longitude > ?-0.1 and longitude < ?+0.05";
		ResultSet rst=dbhelper.execQuery(sql, lat,lat,lon,lon);
		
		ArrayList<Footprint> footprints = new ArrayList<Footprint>();
		try {
			while(rst.next()){
				Footprint footprint=new Footprint();
				footprint.setFoot_id(rst.getInt("foot_id"));
				footprint.setUser_id(rst.getInt("user_id"));
				footprint.setLatitude(rst.getDouble("latitude"));
				footprint.setLongitude(rst.getDouble("longitude"));
				footprint.setComment(rst.getString("comment"));
				footprint.setPicture(rst.getString("picture"));
				footprint.setCreate_time(rst.getTimestamp("create_time"));
				footprints.add(footprint);
			}
			rst.close();
			return footprints;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closeAll();
		}	
		return null;
	}

	@Override
	public int addOneFootprint(Footprint footprint) {
		// TODO Auto-generated method stub
		String sql="insert into footprint(user_id,latitude,longitude,comment,picture) values(?,?,?,?,?)";
		int n =dbhelper.execOthers(sql,footprint.getUser_id(),footprint.getLatitude(),footprint.getLongitude(),footprint.getComment(),footprint.getPicture());
		dbhelper.closeAll();
		return n;
	}

	
	
}
