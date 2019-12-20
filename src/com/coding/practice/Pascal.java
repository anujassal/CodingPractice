package com.coding.practice;


public class Pascal {
	
	public static int[] pascal(int n) {
		if(n==0) {
			return new int[] {1};
		}
		if(n==1) {
			return new int[] {1,1};
		}
		int[] currRow = new int[n];
		if(n>1) {
			int[] prevRow = pascal(n-1);
			currRow[0]=1;
			for(int i=1;i<n-1;i++) {
				currRow[i] = prevRow[i-1]+prevRow[i];
			}
			currRow[n-1]=1;
		}
		return currRow;
	}
	
	public static void main(String[] args) {
		int[] result = pascal(6);
		System.out.println(result);
	}

}
