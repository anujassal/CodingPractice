package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A=[4,5,0,-2,-3,1], k=5
 * output = 7;
 * @author charan
 *
 */

public class SubArraySum {
	
	public static void main(String[] args){
		//int[] arr = new int[]{4,5,0,-2,-3,1};
		int[] arr = new int[]{4,5,0};
		List<List<Integer>> subArrayList = new ArrayList<>();
		int elemCount = arr.length;
		int i=1;
		while(i<=elemCount){
			subArrayList = findSum(arr,i,subArrayList);
			i++;
		}
		List<List<Integer>> newList = subArrayList.stream().distinct().collect(Collectors.toList());
		System.out.println(newList.size());
	}
	
	private static List<List<Integer>> findSum(int[] arr,int count,List<List<Integer>> subArrayList){
		
		if(arr.length==0){
			return Collections.EMPTY_LIST;
		}
		if(arr.length==1){
			List<Integer> list = new ArrayList<>();
			list.add(arr[0]);
			subArrayList.add(list);
			return subArrayList;
		}
		for(int i=0;i<arr.length;i++){
			int sum = 0;
			for(int j=i;j<i+count&&j<arr.length;j++){
				sum=sum+arr[j];
			}
			if(sum%5==0){
				List<Integer> list = new ArrayList<>();
				for(int j=i;j<i+count&&j<arr.length;j++){
					list.add(arr[j]);
				}
				if(!list.isEmpty()){
					subArrayList.add(list);
				}
			}
		}
		return subArrayList;
	}

}
