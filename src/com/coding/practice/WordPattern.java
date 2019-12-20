package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	
	/**
	 * pattern ="abba" str="dog cat dog cat";
	 * split str into str[]
	 * go over pattern and add the char to map. 
	 * for each char in pattern map it to str[i].
	 * if same char found, check if its value is same as in str[i].
	 * if not return false.
	 */
	
	public static boolean wordPattern(String pattern, String str) {
		String[] strArr = str.split(" ");
		int m=pattern.length();
		int n=strArr.length;
		if(m!=n) {
			return false;
		}
		Map<Character,String> map = new HashMap<>();
		for(int i=0;i<m;i++) {
			if(map.get(pattern.charAt(i))!=null) {
				if(!map.get(pattern.charAt(i)).equals(strArr[i]))
						return false;
				
			}else {
				if(map.containsValue(strArr[i])) {
					return false;
				}
				map.put(pattern.charAt(i),strArr[i]);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog cat cat dog"));
		System.out.println(wordPattern("abba","dog cat dog fish"));
		System.out.println(wordPattern("aaaa","dog cat cat dog"));
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}

}
