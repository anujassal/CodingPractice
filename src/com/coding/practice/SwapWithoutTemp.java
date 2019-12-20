package com.coding.practice;


public class SwapWithoutTemp {
	
	public static void main(String[] args){
		int x = 100;
		int y=9;
		System.out.println("Before Swap " + x +" " + y);
		x = x+y;
		y = x-y;
		x= x-y;
		System.out.println("After Swap " + x +" " +y);
	}

}
