package com.wmz.demo.helper;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.wmz.pos.servlet.GetConsumeRecord;

public class JsonTools {
	public static String getAds() {

		String[] urls = { "http://pic1a.nipic.com/2008-09-05/200895134351570_2.jpg",
				"http://pic12.nipic.com/20101227/4750538_110523035117_2.jpg" };

		JSONArray jsonArray = new JSONArray();
		try {
			for (int i = 0; i < urls.length; i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", i);
				jsonObject.put("url", urls[i]);
				jsonObject.put("name", "name_" + i);
				jsonArray.put(i, jsonObject);
			}
			return jsonArray.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static String checkTickets(String status){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status", status);
			jsonObject.put("msg", "6"); 
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("name", "1"); 
			jsonObject2.put("cardPwd", "2"); 
			jsonObject2.put("printnum", "3"); 
			jsonObject2.put("num", "4"); 
			jsonObject2.put("endTim", "5");
			jsonObject.put("data", jsonObject2); 
			return jsonObject.toString(); 
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static String checkIsOnline(){
		JSONObject jsonObject = new JSONObject(); 
		try {
			jsonObject.put("status", "true");
			jsonObject.put("msg", "msg"); 
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("inspector_id", "1");
			jsonObject2.put("sessionId", "2");
			jsonObject2.put("shop_id", "3");
			jsonObject.put("data", jsonObject2); 
			return jsonObject.toString(); 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		} 
	}
	
	public static String login(String status){
		JSONObject jsonObject = new JSONObject(); 
		try {
			jsonObject.put("status", status);
			jsonObject.put("msg", "login success"); 
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("inspector_id", "1"); 
			jsonObject2.put("sessionId","2");
			jsonObject2.put("shop_id", "3"); 
			jsonObject.put("data", jsonObject2); 
			return jsonObject.toString(); 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		} 
	}
	
	public static String checkVersion(){
		JSONObject jsonObject = new JSONObject(); 
		try {
			jsonObject.put("status", "true");
			jsonObject.put("msg", ""); 
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("versionCode", "1"); 
			jsonObject2.put("versionName", "2"); 
			jsonObject2.put("downloadUrl", "/Demo/CheckVersion");
			jsonObject2.put("updateLog", "3"); 
			jsonObject.put("data", jsonObject2); 
			return jsonObject.toString(); 
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String consume(String status){
		JSONObject jsonObject = new JSONObject(); 
		try {
			jsonObject.put("status", status); 
			jsonObject.put("msg", "msg");
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("shopName", "´¶ÑÌÐ¡³ø");
			jsonObject2.put("operator", "wmz");
			jsonObject2.put("consumeMoney", "100¿é"); 
			jsonObject2.put("date", "2015-08-31 12:00"); 
			jsonObject.put("data", jsonObject2);
			return jsonObject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		} 
	}
	
	public static String getConsumeRecord(String status){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status", status);
			jsonObject.put("msg", "msg");
			JSONArray jsonArray = new JSONArray(); 
			
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("shopName", "´¶ÑÌÐ¡³ø");
				jsonObject2.put("operator", "wmz");
				jsonObject2.put("consumeMoney", "100¿é");
				jsonObject2.put("date", "2015-08-31 12:00");
				jsonArray.put(jsonObject2); 
			
				JSONObject jsonObject3 = new JSONObject();
				jsonObject3.put("shopName", "±ØºÃ»õÀÊ¿Æµê");
				jsonObject3.put("operator", "01026");
				jsonObject3.put("consumeMoney", "3.5");
				jsonObject3.put("date", "2015-08-31 12:50");
				jsonArray.put( jsonObject3);
				
			jsonObject.put("data", jsonArray); 
			 return jsonObject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
	}
}
