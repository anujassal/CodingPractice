package com.coding.practice;


public class FindElemInPivotedArray {
	
	public static int findPivotIdx(int[] arr,int lo,int hi) {
		if(lo>hi) {
			return -1;
		}
		if(lo==hi) {
			return lo;
		}
		int mid = (lo+hi)/2;
		if(mid<hi && arr[mid]>arr[mid+1]) {
			return mid+1;
		}
		if(mid>lo && arr[mid]<arr[mid-1]){
			return mid;
		}
		if(arr[lo]>=arr[mid]) {
			return findPivotIdx(arr,lo,mid-1);
		}
		return findPivotIdx(arr,mid+1,hi);
	}
	
	public static int findElem(int[] arr,int target) {
		int pivotIdx = findPivotIdx(arr,0,arr.length-1);
		if(pivotIdx!=-1) {
			if(target==arr[pivotIdx]) {
				return pivotIdx;
			}
			if(target>arr[pivotIdx]&&target<arr[arr.length-1]) {
				return binarySearch(arr,pivotIdx,arr.length-1,target);
			}else {
				return binarySearch(arr,0,pivotIdx-1,target);
			}
		}	
		return -1;
	}
	public static int binarySearch(int[] arr,int lo,int hi,int target) {
		if(lo>hi) {
			return -1;
		}
		int mid = (lo+hi)/2;
		if(target==arr[mid]) {
			return mid;
		}
		if(target<arr[mid]) {
			return binarySearch(arr,0,mid,target);
		}else {
			return binarySearch(arr,mid+1,arr.length-1,target);
		}	
	}
	
	public static void main(String[] args) {
		int[] arr = {15,16,19,20,25,1,3,4,5,7,10,14};
		int target = 5;
		System.out.println(findElem(arr,target));
	}
}
