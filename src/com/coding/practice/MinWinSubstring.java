package com.coding.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * S=ABOBECODEBANC,T=ABC
 * OUPUT=BANC
 */
public class MinWinSubstring {
	
	public static void main(String[] args){
		//String s = "ABOBECODEBANC";
		//String t = "ABC";
		String s = "a";
		String t = "aa";
		System.out.println(minWinSubstring(s,t));

	}
	
	private static Map<Character,Integer> reset(Map<Character,Integer> map,String t){
		for(int i=-0;i<t.length();i++){
			map.put(t.charAt(i), -1);
		}
		return map;
	}
	
	private static String minWinSubstring(String s,String t){
		Map<Character,Integer> map = new TreeMap<>();
		map = reset(map,t);
		int[] finalResult = new int[2];
		int finalSize=-1;

		for(int i=0;i<s.length();i++){
			if(map.get(s.charAt(i))!=null && map.get(s.charAt(i))==-1){
				map.put(s.charAt(i), i);
			}
			if(!map.containsValue(-1)){
				//result = first and last value of the map.
				//size = result[1]-result[0];
				LinkedHashMap<Character,Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1,e2)->e1,LinkedHashMap::new));
				int[] result = new int[2];
				Object[] array = sortedMap.values().toArray();
				result[0] = (int)array[0];
				result[1] = (int)array[sortedMap.size()-1];
				int prevSize = finalSize;
				finalSize = result[1]-result[0];
				//finalSize = newSize;
				reset(map,t);//reset the map
				if(finalSize<prevSize){
					//finalSize = prevSize;
					finalResult[0] = result[0];
					finalResult[1] = result[1];
				}
			}
		}
		int start = finalResult[0];
		int end = finalResult[1];
		String result = s.substring(start,end+1);
		return result;
	}

}
