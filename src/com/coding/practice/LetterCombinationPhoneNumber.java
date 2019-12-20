package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {
	

	static Map<Character,String> map = createMap();

	
	private static Map<Character,String> createMap(){
		Map<Character,String> map = new HashMap<>();
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
		return map;
	}
	
	public static List<String> letterCombination(String input){
		char[] arr = input.toCharArray();
		List<String> list = new ArrayList<>();
		for(char c:arr) {
			if(map.get(c)!=null)
				list.add(map.get(c));
			else {
				throw new IllegalArgumentException(c + " is not a valid number");
			}
		}
		List<String> result = new ArrayList<>();
		for(int i=0;i<list.size()-1;i++) {
			int j = i+1;
			int b = 0;
			for(int a=0;a<list.get(i).length();a++) {
				while(b<list.get(j).length()) {
					String s = String.valueOf(list.get(i).charAt(a))+String.valueOf(list.get(j).charAt(b));
					result.add(s);
					b++;	
				}
				b=0;
			}
		}
		return result;
	}
	
	public static List<String> letterCombos(String input){
		List<String> result = new ArrayList<>();
		letterCombos(input,0,result,"");
		return result;
	}
	
	public static void letterCombos(String input,int i,List<String> result,String soFar) {
		if(i==input.length()) {
			result.add(soFar);
			return;
		}else {
			String usable = map.get(input.charAt(i));
			for(int j =0;j<usable.length();i++) {
				letterCombos(input,i+1,result,soFar+usable.charAt(j));
			}
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(letterCombination("134"));
		System.out.println(letterCombos("34"));
	}

}
