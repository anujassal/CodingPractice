package com.coding.practice;


public class Unique {
	
	public static void main(String args[]){
		System.out.println(isUnique("Anudeep"));
	}
	
	public static boolean isUnique(String str){
		boolean char_set[] = new boolean[256];
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			System.out.println(val);
			if(char_set[val]) return false;
			char_set[val] = true; 
		}
		return true;
	}

}
