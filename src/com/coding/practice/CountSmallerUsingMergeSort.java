package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerUsingMergeSort {
	
	static class Item{
		int v;
		int index;
		Item(int value,int idx){
			v = value;
			index = idx;
		}
	}
	
	public List<Integer> countSmaller(int[] nums){
		int n = nums.length;
		Item[] items = new Item[n];
		for(int i=0;i<n;i++){
			items[i] = new Item(nums[i],i);
		}
		int count[] = new int[n];
		mergesort(items,0,n-1,count);
		List<Integer> res = new ArrayList<>();
		for(int c:count){
			res.add(c);
		}
		return res;
	}
	
	private static void mergesort(Item[] items,int lo, int hi,int[] count){
		if(lo>=hi)
			return;
		//(lo+(hi-lo))/2
		int mid = (lo+hi)/2;
		mergesort(items,lo,mid,count);
		mergesort(items,mid+1,hi,count);
		merge(items,lo,mid,mid+1,hi,count);
	}
	
	private static void merge(Item[] items, int lo, int loEnd,int hi, int hiEnd,int[] count){
		int m = hiEnd - lo +1;
		Item [] sorted = new Item[m];
		int index = 0;
		int lowPtr = lo;
		int highPtr = hi;
		int rightCounter = 0;
		while(lowPtr<=loEnd&&highPtr<=hiEnd){
			if(items[highPtr].v<items[lowPtr].v){
				rightCounter++;
				sorted[index++] = items[highPtr++];
			}else{
				count[items[lowPtr].index] += rightCounter;
				sorted[index++] = items[lowPtr++];
			}
		}
		while(lowPtr<=loEnd){
			count[items[lowPtr].index] += rightCounter;
			sorted[index++] = items[lowPtr++];
		}
		while(highPtr<=hiEnd){
			sorted[index++] = items[highPtr++];
		}
	}
	
	public static void main(String[] args){
		
	}

}
