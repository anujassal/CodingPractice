package com.coding.practice;

public class MinCostPath {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minCostPath(matrix));
	}
	
	public static int minCostPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		//fill up the first row [0][i]
		int sum = 0;
		int[][] temp = new int[m][n];
		for(int i=0;i<n;i++) {
			temp[0][i] = sum+matrix[0][i];
			sum=temp[0][i];
		}
		
		//fill up the first col [i][0]
		sum = 0;
		for(int i=0;i<m;i++) {
			temp[i][0] = sum+matrix[i][0];
			sum=temp[i][0];
		}
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(isValid(i,j,m,n))
					temp[i][j] = matrix[i][j]+Math.min(temp[i-1][j],temp[i][j-1]);
			}
		}
		return temp[m-1][n-1];
	}
	
	private static boolean isValid(int i,int j,int m,int n) {
		 return !(i<0||j<0||i>m-1||j>n-1);
			
	}

}
