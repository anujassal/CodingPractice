package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	
	public static String spitSentence(String str,int low,Set<String> dict){
		StringBuilder builder = new StringBuilder();
		for(int i=low;i<str.length();i++) {
			builder.append(str.charAt(i));
			if(dict.contains(builder.toString())) {
				String res = spitSentence(str,i+1,dict);
				if(res!=null) {
					return builder.toString()+" "+res;
				}
			}
			if(dict.contains(builder.toString())) {
				return builder.toString();
				
			}
			
		}
	return null;	
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		System.out.println(spitSentence("catsanddog",0,dict));
	}
	


}
