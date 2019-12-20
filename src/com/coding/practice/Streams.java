package com.coding.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	
	public static void main(String[] args){
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> newList = listOfIntegers.stream().filter(i->i%2!=0)
				.filter(i->i<5).collect(Collectors.toList());
		newList.forEach(System.out::println);
	}

}
 