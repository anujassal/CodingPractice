package com.coding.practice;


import java.util.Scanner; 
public class GFG {
	
	public static void main(String args[]){
		Scanner in  = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		int sizeOfArray = 0;
		for(int i=1;i<=numberOfTestCases;i++){
			sizeOfArray = in.nextInt();
			String array = in.nextLine();
			String[] arrayElements = array.split("");
			int missingNumber = getMissingNumber(arrayElements,sizeOfArray);
			System.out.println(missingNumber +" is missing number for test case "+i);
}
			
		in.close();
	}
	
	private static int getMissingNumber(String[] array, int arraySize){
		for(int i=0;i<arraySize;i++){
			if(Integer.valueOf(array[i])!=i)
				return i;
		}
		return 0;
		
	}

}
