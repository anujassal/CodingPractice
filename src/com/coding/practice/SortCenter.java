package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class SortCenter {
	
	public static void main(String[] args){
		int[] nums = {1,10,25,35,60,59};
		int target = 60;
		int [] result = findSum(nums,target);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
	public static int[] findSum(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int complement = target - nums[i];
			if(map.containsKey(complement)){
				return new int[]{nums[i],complement};
			}
				map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
