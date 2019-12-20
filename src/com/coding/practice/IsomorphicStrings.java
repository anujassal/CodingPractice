package com.coding.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public static void main(String[] args){
		String s1 = "paper";
		String s2 = "title";
		System.out.println(isIsomorphicStrings(s1,s2));
	}
	
	private static boolean isIsomorphicStrings(String str1,String str2){
		//compare the lengths of two strings
		if(str1==null || str2==null)
			return false;
		if(str1.length()!=str2.length())
			return false;
		//count the # of occurrences of each of the characters and store in an array.
		Map<Character,Integer> map = new LinkedHashMap<>();
		Map<Character,Integer> map2 = new LinkedHashMap<>();
		for(int i=0;i<str1.length();i++){
			map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
			map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0)+1);
			if(!(map.get(str1.charAt(i)).equals(map2.get(str2.charAt(i))))){
				return false;
			}
		}
		return true;
		
		
		
	}

}
