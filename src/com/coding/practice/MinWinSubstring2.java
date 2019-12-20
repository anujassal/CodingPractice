package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class MinWinSubstring2 {
	
	public static void main(String[] args){
		
	}
	
	public String minWinSubstring(String s,String t){
		
		Map<Character,Integer> targetCharCtnMap = new HashMap<>();
		Map<Character,Integer> minWinCtnMap = new HashMap<>();
		for(int i=0;i<t.length();i++){
			targetCharCtnMap.put(t.charAt(i), targetCharCtnMap.getOrDefault(t.charAt(i),0)+1);
		}
		
		
		
		int left=0,right=0;
		int required = targetCharCtnMap.size();
		int formed = 0;
		int[] ans = {-1,0,0};
		
		while(left<s.length()){
			char c = s.charAt(right);
			minWinCtnMap.put(c, minWinCtnMap.getOrDefault(c, 0)+1);
			if(targetCharCtnMap.containsKey(c) && targetCharCtnMap.get(c).intValue()==minWinCtnMap.get(c).intValue()){
				formed++;
			}
			
			while(left<=right && formed==required){
				c = s.charAt(left);
				
				if(ans[0]==-1 || left-right+1<ans[0]){
					ans[0] = right-left+1;
					ans[1] = left;
					ans[2] = right;
				}
				
				minWinCtnMap.put(c, targetCharCtnMap.get(c)-1);
				if(targetCharCtnMap.containsKey(c) && targetCharCtnMap.get(c).intValue()<minWinCtnMap.get(c).intValue()){
					formed--;
				}
				left++;
			}
			right++;
		}
		return ans[0]==-1?"":s.substring(ans[1], ans[2]+1);
		
	}

}
