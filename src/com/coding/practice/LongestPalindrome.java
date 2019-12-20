package com.coding.practice;


public class LongestPalindrome {
	
	public static void main(String[] args){
		String s = "babad";
		System.out.println(getLongestPalindromicString(s));
	}

	public static String getLongestPalindromicString(String s){
		int sLen = s.length();
		boolean[][] sTable = new boolean[sLen][sLen];
		String longestPalindrome = "";
		
		if(s==null || s.length()<=1)
			return s;
		
		//set single char to true
		for(int i=0;i<sLen;i++){
			sTable[i][i] = true;
			if(longestPalindrome.length()<s.substring(i,i+1).length())
				longestPalindrome = s.substring(i,i+1);
		}
		
		//set two matching chars to true
		for(int i=0;i<sLen-1;i++)
			if(s.charAt(i)==s.charAt(i+1)){
				sTable[i][i+1] = true;
				if(longestPalindrome.length()<s.substring(i, i+2).length())
					longestPalindrome = s.substring(i, i+2);
			}
		
		//char>2
		for(int i=0;i<sLen;i++){
			for(int j=i+2;j<sLen;j++){
				if(s.charAt(i)==s.charAt(j)&&sTable[i+1][j-1]==true){
					sTable[i][j]=true;
					if(longestPalindrome.length()<s.substring(i, j+1).length())
						longestPalindrome = s.substring(i, j+1);
				}
	}
		}
		return longestPalindrome;
}
}
