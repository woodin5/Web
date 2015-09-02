package com.wmz.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wmz.demo.bean.UserBean;

public class DBTools {
	public static List<UserBean> getUsers(){
		List<UserBean> list = new ArrayList<>(); 
		ResultSet rs = null; 
		String sql = "select * from table_users"; 
		DBHelper db = new DBHelper(sql); 
		try {
			rs = db.pst.executeQuery();
			while(rs.next()){
				UserBean bean = new UserBean(); 
				bean.setUserId(rs.getString(1));
				bean.setUserName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setGrade(rs.getInt(4));
				list.add(bean); 
			}
			rs.close(); 
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list.size()>1?list:null; 
	}
}
