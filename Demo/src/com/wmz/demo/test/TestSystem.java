package com.wmz.demo.test;

public class TestSystem {
	public static void main(String[] args) {
		String s = "0aec5ffe";  
//		String s1 = Integer.toString(Integer.parseInt(s, 16));  
		String s2 = Long.toString(Long.parseLong(s, 16));  
		System.out.println(s2);
	}
}
