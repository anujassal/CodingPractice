package com.coding.practice;

public class FindFirstLast {
	
	public static void main(String[] args){
		int[] arr = {5,7,8,8,8,8};
		findIndex(arr,8);
	}
	
	public static void findIndex(int[] arr, int target){
		int[] range = binarySearch(arr,target);
		System.out.println("["+range[0]+","+range[1]+"]");
	}
	
	public static int[] binarySearch(int[] arr,int target){
		int low = 0,high = arr.length-1;
		
		int[] range = {-1,-1};
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid]<target){
				low = mid+1;
			} else if(arr[mid]>target){
				high = mid-1;
			}else{
				int idx1 = findLeftIndex(arr,0,mid,target);
				int idx2 = findRightIndex(arr,mid+1,arr.length,target);
				range[0] = idx1;
				range[1] = idx2;
				return range;
			}
		}
		return range;
	}
	
	private static int findLeftIndex(int[] arr,int left,int right,int target){
		while(left<right){
			int mid = (left+right)/2;
			if(arr[mid]<target)
				left = mid+1;
			else if(arr[mid-1]<target)
				return mid;
			else
				right = mid-1;
		}
		return left;
	}
	
	private static int findRightIndex(int[] arr,int left,int right,int target){
		while(left<right){
			int mid = (left+right)/2;
			if(arr[mid]>target)
				right=mid-1;
			else if(arr[mid-1]>target)
				return mid;
			else
				left=mid+1;
		}
		return right;
	}

}
