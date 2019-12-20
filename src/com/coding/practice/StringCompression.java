package com.coding.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {
	/**
	 * Input - ["a","a","b","b","c","c","c"]
	 */
	
	public static void main(String[] args){
		
		String[] strArr = {"a","a","b","b","c","c","c"};
		
		int arrLen = compresssString(strArr);
		
		System.out.println(arrLen);
		
		for(int i=0;i<arrLen;i++){
			System.out.println(strArr[i]);
		}	
	}
	
	private static int compresssString(String[] strArr){
		if(strArr.length==0)
			return 0;
		Map<String,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<strArr.length;i++){
			map.put(strArr[i], map.getOrDefault(strArr[i], 0)+1);
		}
		int j=0;
		int i=0;
		int nextIdx = 0;
		for(;i<map.entrySet().size();i++){
			int count = map.get(strArr[nextIdx]);
			String key = strArr[nextIdx];
			strArr[j] = key;
			strArr[j+1] = String.valueOf(count);
			j = j+2;
			nextIdx = count+nextIdx;
		}
		while(j<strArr.length){
			strArr[j] = "";
			j++;
		}
		return nextIdx;	
	}

}
