package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets2 {
	
	public static List<List<Integer>> subsets(int[] arr,int i,List<List<Integer>> global){
		if(arr.length==i) {
			global.add(Collections.emptyList());
			return global;
		}
		List<List<Integer>> globalCopy = new ArrayList<>();

		global = subsets(arr,i+1,global);
				for(List<Integer> l:global) {
					List<Integer> subset = new ArrayList<>();
					subset.addAll(l);
					subset.add(arr[i]);
					globalCopy.add(subset);
				}
			global.addAll(globalCopy);
		return global;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> global = new ArrayList<>();
		subsets(nums,0,global).forEach(l->System.out.println(l));
	}

}
