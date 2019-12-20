package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public static final Map<Character,Integer> romanIntMap = new HashMap<>();
	static{
		romanIntMap.put('I',1);
		romanIntMap.put('V',5);
		romanIntMap.put('X',10);
		romanIntMap.put('L',50);
		romanIntMap.put('C',100);
		romanIntMap.put('D',500);
		romanIntMap.put('M',1000);
	}
	
	public static int romanToInteger(String roman){
		int sum = 0;
		int i=0;
		if(roman.length()==1)
			return romanIntMap.get(roman.charAt(i));
		while( i<roman.length()-1){
			if(i==roman.length()-2)
				sum += romanIntMap.get(roman.charAt(i+1));
			if(romanIntMap.get(roman.charAt(i))>=romanIntMap.get(roman.charAt(i+1)))
				sum += romanIntMap.get(roman.charAt(i++));
			else
				sum -= romanIntMap.get(roman.charAt(i++));
		}
		return sum;	
	}
	
	public static void main(String[] args){
		System.out.println(romanToInteger("D"));
		System.out.println(romanToInteger("III"));
		System.out.println(romanToInteger("IV"));
		System.out.println(romanToInteger("IX"));
		System.out.println(romanToInteger("LVIII"));
		System.out.println(romanToInteger("MCMXCIV"));
		
	}

}
