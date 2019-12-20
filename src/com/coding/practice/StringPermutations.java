package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	public static List<String> permutate(String s){
		List<String> permutations = new ArrayList<>();
		if(s==null) {
			return null;
		}
		if(s.length()==0) {
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0);
		List<String> remainder = permutate(s.substring(1));
		for(String st:remainder) {
			for(int i=0;i<=st.length();i++) {
				permutations.add(insertChar(first,st,i));
			}
	}
return permutations;
	}
	
	public static String insertChar(char first,String remainder,int i) {
		String start = remainder.substring(0,i);
		String end = remainder.substring(i);
		return start + first + end;
		}
	
	public static void main(String[] args) {
		System.out.println(permutate("abc"));
	}

}
