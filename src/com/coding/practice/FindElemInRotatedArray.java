package com.coding.practice;


public class FindElemInRotatedArray {
	
	private static int findPivotIndex(int[] arr,int start, int end){
		int middle = (start+end)/2;
		if(arr[middle]>arr[middle+1])//check if the sorted array continuity breaks here
			return middle + 1;
		else{
			if(arr[start]>arr[middle]){
				return findPivotIndex(arr,start,middle-1);
			}else{
				return findPivotIndex(arr,middle+1,start);
			}
		}
	}
	
	private static int findElement(int[] arr,int start,int end,int elem){
		int middle = (start+end)/2;
		if(arr[middle]==elem)
			return middle;
		if(elem<arr[middle])
			return findElement(arr,start,middle-1,elem);
		else
			return findElement(arr,middle+1,end,elem);
	}
	
	public static void main(String[] args){
		int arr[] = {3,4,5,1,2};
		int elem = 3;
		int end = arr.length -1;
		int start = 0;
		int pivotIndex = findPivotIndex(arr,start, end);
		System.out.println(pivotIndex);
		int index = -1;
		if(elem==arr[pivotIndex])
			index = pivotIndex;
		if(elem>arr[pivotIndex] && elem<=arr[end])
			index = findElement(arr,pivotIndex+1,end,elem);
		else
			index = findElement(arr,start,pivotIndex-1,elem);
		System.out.println(index);
	}

}
