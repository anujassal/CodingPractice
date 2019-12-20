package com.coding.practice;

import java.util.LinkedList;

public class MatrixPrintShortestPath {
	/**
	 * Time complexity:O(n2)
	 * Space complexity:O(n2)
	 * 
	 *
	 */
	
	private static class Cell implements Comparable<Cell>{
		
		int x;
		int y;
		int dist;
		Cell prev;
		boolean isVisited = false;
		
		Cell(int x,int y,int dist,Cell prev){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.prev = prev;	
		}

		@Override
		public int compareTo(Cell o) {
			return dist-o.dist;
		} 
		
		@Override
		public String toString(){
			return "("+x+","+y+")";
		}
		
		public static void shortestPath(int[][] matrix,int[] start,int[] end){
			if(matrix[start[0]][start[1]]==0||matrix[end[0]][end[1]]==0)
				return;
			
			Cell[][] cells = new Cell[matrix.length][matrix[0].length];
			for(int i=0;i<cells.length;i++){
				for(int j=0;j<cells.length;j++)
					if(matrix[i][j]!=0){
						cells[i][j]=new Cell(i,j,Integer.MAX_VALUE,null);
					}
			}
			LinkedList<Cell> queue = new LinkedList<>();
			Cell src = cells[start[0]][start[1]];
			src.dist = 0;
			src.isVisited = true;
			queue.add(src);
			Cell dest = null;
			Cell curr;
			while((curr=queue.poll())!=null){
				if(curr.x==end[0]&&curr.y==end[1]){
					dest = curr;
				}
				visit(cells,queue,curr.x-1,curr.y,curr);
				visit(cells,queue,curr.x+1,curr.y,curr);
				visit(cells,queue,curr.x,curr.y-1,curr);
				visit(cells,queue,curr.x,curr.y+1,curr);
			}
			if(dest==null){
				return;
			}else{
				LinkedList<Cell> path = new LinkedList<>();
				curr = dest;
				System.out.println(dest.dist);
				do{
					path.addFirst(curr);
				}while((curr = curr.prev)!=null);
				System.out.println(path);
			}
		}
		static void visit(Cell[][] cells,LinkedList<Cell> queue,int x, int y, Cell parent){
			int dist = parent.dist+1;
			if(x<0||x>cells.length||y<0||y>=cells[0].length){
				return;
			}
			Cell curr = cells[x][y];
			if(curr!=null&&!curr.isVisited){
				curr.dist = dist;
				curr.prev = parent;
				curr.isVisited = true;
				queue.add(curr);
			}
			
		}
		
		public static void main(String[] args){
			int[][] matrix = new int[][]{
				{1,1,1,1,1,1},
				{1,1,1,1,0,1},
				{1,0,0,0,1,1},
				{1,1,1,1,1,1},
				{0,0,0,0,0,0}
			};
			int[] start = {2,4};
			int[] end = {3,2};
			shortestPath(matrix,start,end);
		}
	}

}
