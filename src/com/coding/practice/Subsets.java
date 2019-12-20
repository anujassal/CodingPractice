package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void subsets(int[] arr,int i){
		if(arr.length==1) {
			List<Integer> l = new ArrayList<>();
			l.add(arr[i]);
		}
		List<Integer> l = new ArrayList<>();
		l.add(arr[i]);
		subsets(arr,i+1);
	}

}
