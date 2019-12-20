package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author charan
 * nums=[2,7,11,15] target = 9 return [0,1]
 *
 */

public class TwoSum2 {
	
	public static void main(String[] args){
		
		List<Integer> nums = Arrays.asList(2,7,11,15);
		getTwoSum(nums,9).forEach(s->System.out.println(s));;
		
	}
	
	private static List<Integer> getTwoSum(List<Integer> nums, int target){
	
		Map<Integer,Integer> complementMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<nums.size();i++){
			int complement = target - nums.get(i);
			if(complementMap.containsKey(complement)){
				 result.add(complementMap.get(complement));
				 result.add(i);
			}else
				complementMap.put(nums.get(i), i);
		}
		return result;
	}
}
