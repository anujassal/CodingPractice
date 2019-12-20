package com.coding.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequentWords {
	
	public static void main(String[] args){
		String[] arr = new String[]{"i","love","leetcode","i","love","coding"};
		getTopFrequentWords(arr,2);
	}
	
	private static void getTopFrequentWords(String[] arr,int k){
		Map<String,Integer> strToIntMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			strToIntMap.put(arr[i], strToIntMap.getOrDefault(arr[i], 0)+1);
		}
		
		LinkedHashMap<String, Integer> sortedMap = 
				strToIntMap.entrySet().stream()
				                .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
				                             .thenComparing(Map.Entry.comparingByKey())).limit(k)
				                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		sortedMap.forEach((key,value)->{System.out.println(key);});
		
	}

}
