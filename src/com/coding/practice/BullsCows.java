package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

/*
 * Input: secret = "1807", guess = "7810"

Output: "1A3B"
 */

public class BullsCows {
	
	public static void main(String[] args){
		String secret = "1123";
		String guess = "0111";
		System.out.println(getHint(secret,guess));
	}
	
	private static String getHint(String secret,String guess){
		if(secret==null||guess==null)
			return "";
		if(secret!=null && guess!=null && secret.length()!=guess.length())
			return "";
		Map<String,Integer> count = new HashMap<>();
		for(int i=0;i<secret.length();i++){
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if(s==g)
				count.put("A", count.getOrDefault("A", 0)+1);
			else
				count.put("B", count.getOrDefault("B", 0)+1);
		}
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, Integer> entry:count.entrySet()){
			builder.append(entry.getValue());
			builder.append(entry.getKey());
		}
		return builder.toString();
	}

}
