package com.coding.practice;


public class RemoveDuplicates {
	
	public static void main(String args[]){
		String string = "aaaabb";
		char[] arr = string.toCharArray();
		arr = removeDups(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static char[] removeDups(char[] arr){
		
		
		int index = 1;
		for(int i=1;i<arr.length;i++){
			int j;
			for(j=0;j<i;j++){
				if(arr[i]==arr[j])
					break;
			}
			if(j==i)
				arr[index++]=arr[i];
			
		}
		for(int i=index;i<arr.length;i++)
			arr[index++]=0;
		return arr;
	}

}
