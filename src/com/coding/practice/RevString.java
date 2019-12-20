package com.coding.practice;


public class RevString {
	
	public static String revString(String s) {
		if(s.length()==1) {
			return Character.toString(s.charAt(0));
		}
		int idx = s.length()-1;
		return Character.toString(s.charAt(s.length()-1)) + revString(s.substring(0,idx));
	}
	
	public static void main(String[] args) {
		System.out.println(revString("yahoo"));
	}

}
