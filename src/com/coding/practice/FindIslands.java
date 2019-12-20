package com.coding.practice;

public class FindIslands {
	
	public static void main(String[] args){
		int[][] m= new int [][]
				{	{1,1,1,1,0},
					{1,1,0,1,0},
					{1,1,0,0,0},
					{0,0,0,0,0}
		
	};
	System.out.println(findIslands(m));
	}

	private static int findIslands(int[][] m){
		int sumIslands = 0;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				if(m[i][j]==1){
					sumIslands = sumIslands + dfs(m,i,j);
				}
			}
		}
		return sumIslands;
	}
	
	private static int dfs(int[][] m,int i,int j){
		
		if(i>m.length || i<0 || j>m[i].length || j<0)
			return 0;
		dfs(m,i+1,j);
		dfs(m,i-1,j);
		dfs(m,i,j+1);
		dfs(m,i,j-1);
		return 1;
	}
}
