package com.coding.practice;

/**
 * O(n2)
 * @author charan
 *
 */

public class GameOfLife {
	
	
	public static int[][] gameOfLife(int[][] input){
		int m = input.length;
		int n = input[0].length;
		int[][] output = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&j==2) {
					System.out.println();
				}
				int liveNeigbors = getLiveNeighbors(i,j,input);
				if(liveNeigbors<2) {
					output[i][j]=0;
				}
				if((liveNeigbors==2 || liveNeigbors==3) && input[i][j]==1) {
					output[i][j]=1;
				}
				if(liveNeigbors>3) {
					output[i][j]=0;
				}
				if(liveNeigbors==3 && input[i][j]==0) {
					output[i][j]=1;
				}
			}
			
		}
		input = output;
		return output;
	}
	
	public static int getLiveNeighbors(int i, int j,int[][] input) {
		int liveCellsCount = 0;
		if(isValildCell(i,j+1,input) && input[i][j+1]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i,j-1,input) && input[i][j-1]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i+1,j,input) && input[i+1][j]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i-1,j,input) && input[i-1][j]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i-1,j-1,input) && input[i-1][j-1]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i-1,j+1,input) && input[i-1][j+1]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i+1,j-1,input) && input[i+1][j-1]==1) {
			liveCellsCount++;
		}
		if(isValildCell(i+1,j+1,input) && input[i+1][j+1]==1) {
			liveCellsCount++;
		}
		return liveCellsCount;
	}
	
	public static boolean isValildCell(int i, int j,int[][] input) {
		int rowLen = input.length;
		int colLen = input[0].length;
		if(i<0 || j<0 || i>rowLen-1 || j>colLen-1) {
			return false;
		}
		return true;
	}
	
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
