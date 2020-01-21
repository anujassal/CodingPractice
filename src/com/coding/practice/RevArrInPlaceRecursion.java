package com.coding.practice;

public class RevArrInPlaceRecursion {
	
	public static void reverseArray(char[] arr,int left,int right) {
		if(left>=right) {
			return;
		}else {
			swap(arr,left,right);
			reverseArray(arr,left+1,right-1);
		}
	}
	
	private static void swap(char[] arr,int i,int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		char[] arr = {'H','a','n','n','a','h'};
		reverseArray(arr,0,arr.length-1);
		for(char c:arr) {
			System.out.print(c);
		}
	}

}
