package com.creation.where.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creation.where.dao.TogetherService;
import com.creation.where.po.Footprint;
import com.creation.where.po.Together;
import com.creation.where.util.DBHelper;

public class TogetherServiceImpl implements TogetherService{
	private DBHelper dbhelper = new DBHelper();

	@Override
	public int addOneStroke(Together together) {
		// TODO Auto-generated method stub
		String sql="insert into together(what_time,destination,event,people_number,"
				+ "transportation,cost,user_id,join_user) values(?,?,?,?,?,?,?,?)";
		int n =dbhelper.execOthers(sql,together.getWhat_time(),together.getDestination(),together.getEvent(),
				together.getPeople_number(),together.getTransportation(),together.getCost(),together.getUser_id(),together.getJoin_user());
		dbhelper.closeAll();
		return n;
	}

	@Override
	public ArrayList<Together> selectTogethers(Together together,
			Object... objects) {
		String sql="select * from together";
		String where="where latitude > ?-0.05 and latitude < ?+0.05 and longitude > ?-0.1 and longitude < ?+0.05";   //默认推荐附近的行程
		if(objects.length>0){
			sql=sql+where;
		}
		ResultSet rst=dbhelper.execQuery(sql, objects[0],objects[1]);
		
		ArrayList<Together> togethers = new ArrayList<Together>();
		try {
			while(rst.next()){
				Together together2=new Together();
				together2.setTogether_id(rst.getInt("together_id"));
				together2.setWhat_time(rst.getString("what_time"));
				together2.setDestination(rst.getString("destination"));
				together2.setEvent(rst.getString("event"));
				together2.setPeople_number(rst.getInt("people_number"));
				together2.setTransportation(rst.getString("transportation"));
				together2.setCost(rst.getDouble("cost"));
				together2.setUser_id(rst.getInt("user_id"));
				together2.setJoin_user(rst.getString("join_user"));
				together2.setJoin_number(rst.getInt("join_number"));
				togethers.add(together2);
			}
			rst.close();
			return togethers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closeAll();
		}	
		return null;
	}

}
