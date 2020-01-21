package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowSubstring {
	
	public static int slidingWindow(String str) {
	
		int leftWinPtr = 0;
		int rightWinPtr = 0;
		int sLen = str.length();
		int longest = 0;
		Map<Character,Integer> count = new HashMap<>();
		for(rightWinPtr = 0;rightWinPtr<sLen;) {
			if(!count.containsKey(str.charAt(rightWinPtr))) {
				count.put(str.charAt(rightWinPtr),0);
			}
			int c = count.get(str.charAt(rightWinPtr));
			count.put(str.charAt(rightWinPtr),c+1);
			if((count.get(str.charAt(leftWinPtr))>1)) {
				c = count.get(str.charAt(leftWinPtr));
				count.put(str.charAt(leftWinPtr),c-1);
				leftWinPtr++;
			}
			longest = Math.max(longest,leftWinPtr-rightWinPtr+1);
			rightWinPtr++;
		}
		return longest;
	}
	
	public static void main(String[] args) {
		System.out.println(slidingWindow("pwwkew"));
	}
	

}
