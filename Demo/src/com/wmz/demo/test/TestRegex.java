package com.wmz.demo.test;

public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "00"; 
		boolean isNum = str.matches("[0-9\\.]+"); 
		System.out.println(isNum);
		
		int num = Integer.parseInt(str);
		System.out.println(num);
		
	}

}
