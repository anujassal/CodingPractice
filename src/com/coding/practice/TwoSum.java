package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] findTwoSum(int[] arr,int target) {
		Map<Integer,Integer> complementMap = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(complementMap.containsKey(arr[i])) {
				return new int[] {complementMap.get(arr[i]),i};
			}else {
				complementMap.put(target-arr[i],i);
			}
		}
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		int[] result = findTwoSum(arr,9);
		for(int i:result) {
			System.out.println(i);
		}
	}

}
