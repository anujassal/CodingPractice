package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmaller {
	/*
	 * Input: [5,2,6,1]
		Output: [2,1,1,0] 
	 */
	private static int[] arr = {5,2,6,1};
	public static void main(String[] args){
		
		//countSmaller(nums).forEach(e->System.out.println(e));
		int[] nums = new int[arr.length]; 
		mergesort(nums,0,3);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	private static List<Integer> countSmaller(int[] nums){
		if(nums==null)
			return Collections.EMPTY_LIST;
		if(nums.length==0)
			return Collections.EMPTY_LIST;
		List<Integer> output = new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			int count = 0;
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]>nums[j])
					count++;
			}
			output.add(count);
		}
		return output;
	}
	
	private static void mergesort(int[] nums,int lb,int ub){
		if(lb==ub)
			return;
		else{
			int mid = (lb+ub)/2;
			mergesort(nums,lb,mid);
			mergesort(nums,mid+1,ub);
			merge(nums,lb,mid+1,ub);
		}
	}
	
	private static void merge(int nums[],int lowPtr,int highPtr,int ub){
		int mid = highPtr - 1;
		int k=0;
		int lb = lowPtr;
		int n = ub-lb+1;
		while(lowPtr<=mid && highPtr<=ub){
			if(arr[lowPtr]<arr[highPtr]){
				nums[k++]=arr[lowPtr++];
		}else{
			nums[k++]=arr[highPtr++];
		}
	}
		while(lowPtr<=mid){
			nums[k++]=arr[lowPtr++];
		}
		while(highPtr<=mid){
			nums[k++]=arr[highPtr++];
		}
		for(k=0;k<n;k++){
			arr[lb+k]=nums[k];
		}
	}

}
