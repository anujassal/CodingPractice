package com.coding.practice;


public class MaxSubArray {
	
	public int maxSum(int[] nums) {
		
		int curr_sum,global_sum;
		curr_sum=global_sum=nums[0];
		for(int i=1;i<nums.length;i++) {
			curr_sum=Math.max(nums[i],nums[i]+curr_sum);
			if(curr_sum>global_sum) {
				global_sum=curr_sum;
			}
		}
		return global_sum;
	}

}
