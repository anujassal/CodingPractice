package com.coding.practice;


public class IndexOf {
	
	public static void main(String[] args){
		System.out.println(unique("ababaaa"));

	}
	
	public static String unique(String s){
		String str = new String();
		int len = s.length();
		
		for(int i=0;i<len;i++){
			char c = s.charAt(i);
			if(str.indexOf(c)<0)
				str+=c;
		}
		return str;
	}

}
