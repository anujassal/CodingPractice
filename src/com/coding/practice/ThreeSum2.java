package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum2 {
	
	public static List<Integer[]> threeSum(int[] arr,int target) {
		//Map<Integer,Integer> map = new HashMap<>();
		List<Integer[]> result = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int remainder = target-arr[i];
			result = twoSum(arr,i+1,arr.length,remainder);
			if(!result.isEmpty()) {
				for(Integer[] r:result) {
					r[2]=arr[i];
				}
			}
		}
		return result;
	}
	
	public static List<Integer[]> twoSum(int[]  arr,int left,int right,int target) {
		Arrays.sort(arr);
		List<Integer[]> result = new ArrayList<>();
		while(left<right) {
			int twoSum = arr[left]+arr[right];
			if(twoSum==target) {
				result.add(new Integer[] {arr[left],arr[right]});
			}
			if(twoSum>target) {
				right--;
			}else {
				left++;
			}
		}
		return result;
	}
	
	public static int[] twoSum2(int[]  arr,int target) {
		Map<Integer,Integer> map=new HashMap<>();
		int[] result = new int[]{-1,-1};
		for(int i=0;i<arr.length;i++) {
			int complement = target - arr[i];
			if(map.containsKey(arr[i])) {
				result[0] = arr[i];
				result[1] = map.get(arr[i]);
			}else {
				map.put(complement,arr[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		List<Integer[]> result = threeSum(arr,0);
		result.forEach(res->System.out.println("["+res[0]+" , "+res[1]+" , "+res[2]+"]"));
	}

}
