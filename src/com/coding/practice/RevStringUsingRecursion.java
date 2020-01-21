package com.coding.practice;

public class RevStringUsingRecursion {
	
	public static String revString(String str,StringBuilder reversedString) {
		int strLen = str.length();
		if(strLen==1) {
			reversedString.append(str);
		}else {
			reversedString.append(str.charAt(strLen-1));
			revString(str.substring(0,strLen-1),reversedString);
		}
		return reversedString.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(revString("abc",new StringBuilder()));
	}

}
