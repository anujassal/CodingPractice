package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
	
	static List<String> permutations = new ArrayList<>();
	
	public static List<String> permutate(String str){
		char c = str.charAt(0);
		List<String> remainder = permutate(str.substring(1));
		for(String word:remainder) {
			for(int i=0;i<word.length();i++) {
				permutations.add(insertChar(word,c,i));
			}
		}
		return permutations;
	}
	
	public static String insertChar(String str,char c,int i) {
		String start = str.substring(0,i);
		String end = str.substring(i);
		return start+c+end;
	}
}
