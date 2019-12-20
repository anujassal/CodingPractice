package com.coding.practice;

public class SearchMatrix {
	
	/*static class Cell{
		int i;
		int j;
		int value;
		boolean isVisited;
		public Cell(int r,int c,int v){
			this.i = r;
			this.j = c;
			this.value = v;
		}
	}*/
	
	
	public static void main(String[] args){
		int[][] m = new int[][]{
			{1,4,7,11,15},
			{2,5,8,12,19},
			{3,6,9,16,22},
			{10,13,14,17,24},
			{18,21,23,26,30}
		};
		int searchElem = 24;
		
		System.out.println(searchMatrix(m,searchElem));
	}
	
	private static boolean searchMatrix(int[][] m,int searchElem){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				if(m[i][j]==searchElem){
					return true;
				}else{
					if(dfs(i+1,j,m,searchElem)||dfs(i-1,j,m,searchElem)||dfs(i,j+1,m,searchElem)||dfs(i,j-1,m,searchElem))
						return true;
				}
			}
		}
		return false;	
	}
	
	private static boolean dfs(int i,int j,int[][] m,int searchElem){
		if(i>m.length-1 || i<0 || j>m[i].length-1 || j<0 || m[i][j]!=-1){
			return false;
		}
		if(m[i][j]==searchElem){
			return true;
		}
		m[i][j]=-1;
		return false;
	}

}
