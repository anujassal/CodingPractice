package com.coding.practice;

public class FIndElemInRotatedArr {
	
	private static int binarySearch(int[] arr,int start, int end,int target){
		
		int mid = (start+end)/2;
		if(arr[mid]==target){
			return mid;
		}
		if(arr[mid]<target){
			return binarySearch(arr,mid+1,end,target);
		}else if(arr[mid]>target){
			return binarySearch(arr,start,mid-1,target);
		}else{
			return -1;
		}
	}
	
	private static int findPivotIdx(int[] arr, int start, int end){
		int mid = (start+end)/2;
		if(arr[mid]>arr[mid+1])
			return mid+1;
		if(arr[start]>arr[mid]){
			return findPivotIdx(arr,start,mid-1);
		}else
			return findPivotIdx(arr,mid+1,end); 
	}
	
	private static int findElement(int[] arr,int start, int end,int target){
		//find which part of the array we should apply binary search on
		int pIdx = findPivotIdx(arr,start,end);
		if(target==arr[pIdx]){
			return pIdx;
		}
		if(target>=arr[pIdx]&&target<=arr[end]){
			return binarySearch(arr,pIdx+1,end,target);
		}else if(target>=arr[pIdx] && target>=arr[start]){
			return binarySearch(arr,start,pIdx-1,target);
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {4,5,6,7,0,1,2};
		int target = 6;
		System.out.println(findElement(arr,0,arr.length-1,target));
	}
}
