package com.coding.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortLogFile {
	
	private static class LogLines{
		Map<String,String> mapLetters = new HashMap<>();
		Map<String,Integer> mapDigits = new HashMap<>();
		
		public void add(String id,int val){
			mapDigits.put(id, val);
		}
		
		public void addStr(String id,String strVal){
			mapLetters.put(id,strVal);
		}
		
		private static Map<String,String> getSortedMap(Map<String,String> map){
			Map<String,String> sorted = map
					.entrySet()
					.stream()
					.sorted(Comparator.comparing(Entry<String,String>::getValue)
					.thenComparing(Map.Entry.comparingByKey()))
					.collect(
							Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));
			return sorted;
		}
		
		private static Map<String,Integer> getSortedDigitMap(Map<String,Integer> map){
			Map<String,Integer> sorted = map
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(
							Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));
			return sorted;
		}
		
		public Map<String,String> sortedLetter(){
			return getSortedMap(mapLetters);
		}
			
		public Map<String,Integer> sortedDigits(){
			return getSortedDigitMap(mapDigits);
			
		}
				
	}
	
	public static void main(String[] args){
		
		List<String> logLines = Arrays.asList("a1 9 2 3 1","g1 act zoo","ab1 off key dog","zo4 4 7","a8 act car");
		sortLogFile(5,5,logLines);
	}
	
	public static void sortLogFile(int logFileSize, int numLogLines,List<String> logLines){
		
		LogLines ll = new LogLines();;
		logLines.forEach(line->{String[] arr = line.split(" ",2);
		String identifier = arr[0];
		String str = arr[1];
		//check if it is a list of string or integer.
		
		Integer i = null;
		
		try{
			i = Integer.parseInt(str.replace(" ", ""));
			//ll = new LogLines();
			ll.add(identifier, i);
		}catch(NumberFormatException ex){
			ll.addStr(identifier, str);	
		}
		});
		
		ll.sortedLetter().forEach((k,v)->System.out.println(k+" "+ v));
		ll.sortedDigits().forEach((k,v)->{System.out.println(k+" "+v);
			
		});

	}
}
