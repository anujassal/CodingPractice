package com.coding.practice;

public class KandaneMaxSumSubarray {
	
	public static void main(String[] args){
		
	}
	
	private static int maxSum(int[] arr){
		int max_so_far = arr[0];
		int max_ending_here = 0;
		int start = 0;int end = 0; int s = 0;
		for(int i=0;i<arr.length;i++){
			max_ending_here = max_so_far + arr[i];
			if(max_so_far<max_ending_here){
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			if(max_ending_here<0){
				max_ending_here = 0;
				s = i+1;
			}
		}
		return max_so_far;
	}

}
