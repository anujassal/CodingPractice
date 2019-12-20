package com.coding.practice;

public class GameOfLife2 {
	
	private static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	//dead(0)->live(1) - mark as 2
	//live(1)->dead(0) - mark as -1
	

	//[[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]
	public static int[][] gameOfLife(int[][] arr){
		int rowLen = arr.length;
		int colLen = arr[0].length;
		for(int i=0;i<rowLen;i++) {
			for(int j=0;j<colLen;j++) {

				int liveNeighbors = getLiveNeighbors(i,j,arr);
					if((liveNeighbors<2 || liveNeighbors>3)&&arr[i][j]==1) {
						arr[i][j]=-1;
					}
				
					if(liveNeighbors==3 && arr[i][j]==0) {
						arr[i][j]=2;
				
				}
			}
		}
		update(arr,rowLen,colLen);
		return arr;
	}
	
	private static void update(int[][] arr,int rowLen,int colLen) {
		for(int i=0;i<rowLen;i++) {
			for(int j=0;j<colLen;j++) {
				if(arr[i][j]==2) {
					arr[i][j]=1;
				}
				if(arr[i][j]==-1) {
					arr[i][j]=0;
				}
			}
		}
	}
	
	
	private static int getLiveNeighbors(int i,int j,int[][] arr) {
		int liveCellCount = 0;
		int rowLen = arr.length;
		int colLen = arr[0].length;
		if(i==1 && j==0) {
			System.out.println();
		}
		for(int[] d:dirs) {
			int newRow = i+d[0];
			int newCol = j+d[1];
			if(newRow<0||newCol<0||newRow>rowLen-1||newCol>colLen-1) {
				continue;
			}else if(arr[newRow][newCol]==1||arr[newRow][newCol]==-1) {
				liveCellCount++;
			}
		}
		return liveCellCount;
	}
	
	
	//[[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]] 
	public static void main(String[] args) {
		int[][] input = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
		};
		int[][] output = gameOfLife(input);
		System.out.println(output);
	}


}
