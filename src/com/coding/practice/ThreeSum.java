package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args){
		int[] arr = {-1,0,1,2,-1,-4};
		List<int[]> list = getThreeSum(arr);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)[0]+","+list.get(i)[1]+","+list.get(i)[2]);
		}
	}
	
	private static List<int[]> getThreeSum(int[] arr){
		List<int[]> results = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			int start = i+1;
			int end = arr.length -1;
			while(start<end){
				if(arr[i]+arr[start]+arr[end]==1){
					results.add(new int[]{arr[i],arr[start],arr[end]});
				}
				if(arr[i]+arr[start]+arr[end]<1){
					int currStart = start;
					while(arr[start]==arr[currStart]&&start<end)
						start++;
				}else{
					int currEnd = end;
					while(arr[end]==arr[currEnd]&&start<end)
						end--;
				}
					
			}

		}
		return results;
	}

}
