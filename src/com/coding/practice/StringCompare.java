package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class StringCompare {
	
	public static void main(String[] args){
		
		List<String> list = Arrays.asList("a","b","A","B");
		list.sort((s1,s2)->s1.compareToIgnoreCase(s2));
		
		list.sort(String::compareToIgnoreCase);
		
		Function<Integer,Apple> c2 = (weight)->new Apple(weight) ;
		Apple a2 = c2.apply(110);
		
		List<Integer> weights = Arrays.asList(7,3,4,10);
		List<Apple> apples = map(weights,Apple::new);
		
		BiFunction<String, Integer, Apple> c3 = Apple::new;
		Apple a3s = c3.apply("red",110);
	}
	
	public static List<Apple> map(List<Integer> list,Function<Integer,Apple> f){
		List<Apple> result = new ArrayList<>();
		for(Integer e : list){
			result.add(f.apply(e));
		}
		return result;
	}
	
	static Map<String, Function<Integer,Fruit>> map = new HashMap<>();
	static {
		map.put("apple", Apple::new);
		map.put("orange", Orange::new);
	}

}
