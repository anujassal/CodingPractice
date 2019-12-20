package com.coding.practice;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicatesString {
	
	public static void main(String[] args){
		removeDuplicates("Happy New year");
	
	}

	public static void removeDuplicates(String str){
		Set<Character> set = new HashSet<>();
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++){
			char c = charArray[i];
			if(set.contains(c))
				charArray[i] = '0';
			else
				set.add(c);
		}
	
		int j=0;
		for(int i=0;i<charArray.length;i++){
			char c = charArray[i];
			if(c!='0'){
				charArray[j] = charArray[i];
				j++;
			}
		}
		for(int i=0;i<j;i++){
			System.out.println(charArray[i]);
		}
			
	}
}
