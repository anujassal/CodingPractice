package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeats {
	
	public static void main(String[] args){
		
	}
	
	public static String[] maxRepeat(String text){
		String[] words = text.split("[.,!:;'\"-]+\\s*");
		Map<String,Integer> map = new HashMap<>();
		int count = 0;
		for(int i=0;i<words.length;i++){
			if(map.containsKey(words[i])){
				map.get(words[i]);
				
			}
				
		}
		return null;
	}

}
