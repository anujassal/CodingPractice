package com.coding.practice;

import java.util.LinkedList;

public class ShortestPath3 {
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
		
		public static void shortestPath2(int[][] matrix,int[] start){
			
			Cell[][] cells = new Cell[matrix.length][matrix[0].length];
			for(int i=0;i<cells.length;i++){
				for(int j=0;j<cells.length;j++)
					if(matrix[i][j]!='D'){
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
				if(matrix[curr.x][curr.y]=='X'){
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
			if(x<0||x>=cells.length||y<0||y>=cells[0].length){
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
			/*int[][] matrix = new int[][]{
				{'.','.','.','#','.','.','.'},
				{'.','#','.','.','.','#','.'},
				{'.','#','.','.','.','.','.'},
				{'.','.','#','#','.','.','.'},
				{'#','.','#','E','.','#','.'}
			};*/
			int[][] matrix = new int[][]{
				{'S','O','O','S','S'},
				{'D','O','D','O','D'},
				{'O','O','O','O','X'},
				{'X','D','D','O','O'},
				{'X','D','D','D','O'},
			};
			int[] start = {0,0};
			shortestPath2(matrix,start);
		}
	}

}
