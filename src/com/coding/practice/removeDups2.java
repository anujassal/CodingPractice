package com.coding.practice;

import java.util.HashSet;

public class removeDups2 {
	
	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,5,4};
		arr = removeDups(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
	
	public static int[] removeDups(int[] arr){
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++)
			set.add(arr[i]);
		return set.stream().mapToInt(Integer::intValue).toArray();
		
	}


}
