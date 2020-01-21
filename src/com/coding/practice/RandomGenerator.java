package com.coding.practice;

import java.util.Arrays;
import java.util.List;

public class RandomGenerator {
	
	public static int generateRomdomNumber(int n,List<Integer> list) {
		if(list.size()>=n) {
			throw new IllegalArgumentException();
		}
		int rand = (int) (Math.random()*n);
		return list.contains(rand)?generateRomdomNumber(n,list):rand;
		
	}
	
	public static void main(String[] args) {
		int n = 4;
		List<Integer> list = Arrays.asList(1,3);
		System.out.println(generateRomdomNumber(n,list));
	}
	

}
