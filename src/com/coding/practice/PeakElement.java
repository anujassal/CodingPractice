package com.coding.practice;

/**
 * O[logn)
 * @author charan
 *
 */


public class PeakElement {
	
	public static int findPeakElement(int[] arr,int left,int right) {
		int mid = (left+right)/2;
		if((mid==0 || arr[mid]>arr[mid-1]) && (mid==arr.length-1 || arr[mid]>arr[mid+1])) {
			return arr[mid];
		}else if(arr[mid]<arr[mid-1]) {
			return findPeakElement(arr,left,mid);
		}else {
			return findPeakElement(arr,mid+1,right);
		}
	}
	
	public static int localMinima(int[] arr,int left,int right) {
		int mid = (left+right)/2;
		if((mid==0 || arr[mid]<arr[mid-1]) && (mid==arr.length-1 || arr[mid]<arr[mid+1])) {
			return arr[mid];
		}else if(arr[mid]>arr[mid-1]) {
			return localMinima(arr,left,mid);
		}else {
			return localMinima(arr,mid+1,right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {10, 20, 15, 2, 23, 90, 67};
		System.out.println(findPeakElement(arr,0,arr.length));
		
		int[] arr2 = new int[] {4, 3, 1, 14, 16, 40};
		System.out.println(localMinima(arr2,0,arr2.length));
	}

}
