package com.coding.practice;


public class uniqueChars {

	public static void main(String[] args){
		System.out.println(isUniqueChar("abcd"));
	}
	
	public static boolean isUniqueChar(String str){
		boolean[] char_set = new boolean[256];
		for(int i=0;i<str.length();i++){
			int value = str.charAt(i);
			if(char_set[value])return false;
			char_set[value] = true;
		}
		return true;
	}
}
