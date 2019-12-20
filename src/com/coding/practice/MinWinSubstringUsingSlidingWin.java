package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class MinWinSubstringUsingSlidingWin {
	
	public static void main(String[] args){
		//String s = "ABOBECODEBANC";
		//String t = "ABC";
		String s = "a";
		String t = "aa";
		System.out.println(minWinSubstring(s,t));

	}
	
	public static String minWinSubstring(String s,String t){
		//make two maps -> tMap containing the count of the chars and minWinMap containing the count of all the chars in a wind
		//keep two pointers -> right and left, right to expand and left to shrink the window.
		Map<Character,Integer> tMap = new HashMap<>();
		//initialize the map
		for(int i=0;i<t.length();i++){
			int count = tMap.getOrDefault(t.charAt(i),0);
			tMap.put(t.charAt(i), count+1);
		}
		int right=0,left=0;
		int tMapSize = tMap.size();
		int minWinSize = 0;
		int[] result = {-1,0,0};
		Map<Character,Integer> minWinSubStrMap = new HashMap<>();
		while(right<s.length()){
			//move over the string and put the character and count in the map.
			char c = s.charAt(right);
			int count = minWinSubStrMap.getOrDefault(c, 0);
			minWinSubStrMap.put(c, count+1);
			//check if all the characters in t have been covered in the minwin.
			if(tMap.containsKey(c) && minWinSubStrMap.get(c)==tMap.get(c)){
				minWinSize++;
			}
			while(tMapSize==minWinSize && left<=right){
				//record the result
				if(result[0]==-1||result[2]-result[1]>right-left+1){
					result[0] = right-left+1;
					result[1] = left;
					result[2] = right;
				}
				//shrink the min size map
				char c1 = s.charAt(left);
				//remove this char from minWinmap
				int ct = minWinSubStrMap.get(c1);
				ct = ct-1;
				minWinSubStrMap.put(c1, ct);
				if(tMap.containsKey(c1) && minWinSubStrMap.get(c1)<tMap.get(c1))
					minWinSize--;
				left++;
			}
			right++;
		}
		if(result[0]!=-1){
			int start = result[1];
			int end = result[2];
			return s.substring(start,end+1);
		}
		return "";
		}

}
