package com.wmz.demo.test;

import java.util.ArrayList;
import java.util.List;

import com.wmz.demo.bean.UserBean;
import com.wmz.demo.helper.DBTools;

public class TestUser {


	static List<UserBean> list = new ArrayList<>(); 
	public static void main(String[] args) {
		list = DBTools.getUsers(); 
		System.out.println(list);
	}

}
