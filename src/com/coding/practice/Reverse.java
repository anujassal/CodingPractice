package com.coding.practice;


public class Reverse {
	
	public static void main(String[] args){
		char[] reversedArr = reverse("una");
		for(int i=0;i<reversedArr.length;i++)
			System.out.println(reversedArr[i]);
	}
	
	public static char[] reverse(String str){
		char[] arr = str.toCharArray();
		int i=0;
		int j=arr.length-1;
		while(i<=j){
			if(i==j)
				return arr;
			else{
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return arr;
	}
	
	public static void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
