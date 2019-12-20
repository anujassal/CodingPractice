package com.coding.practice;

import java.util.Arrays;

public class Practice {
	
	public static int[] twoSum(int[] nums,int target,int i,int j) {
		//int i=0;
		//int j=nums.length-1;
		Arrays.sort(nums);
		while(i<j) {
			int sum = nums[i]+nums[j];
			if(sum==target) {
				return new int[] {i,j};
			}
			if(sum>target) {
				j--;
			}else {
				i++;
			}
		}
		return new int[]{-1,-1};
	}
	
	public static int[] threeSum(int[] nums,int num) {
		int start = nums[0]; 
		int target = num - start;
		for(int i=1;i<nums.length;i++) {
				int result[] = twoSum(nums,target,i,nums.length);
				if(result[0]!=-1&&result[1]!=-1) {
					return new int[] {start,result[0],result[1]};
			}
		}
		return new int[] {-1,-1,-1};	
	}
	
	public static void main(String[] args) {
		int target = 5;
		int[] nums = new int[] {};
		twoSum(nums,target,0,nums.length);
	}

}
