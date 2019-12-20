package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShortestPath2 {
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
	}
	
	private static class Path{
		LinkedList<Cell> paths = new LinkedList<>();
		int totalDist = 0;
		
		public int getTotalDist(){
			return totalDist;
		}
	}
		
		public static void shortestPath2(int[][] matrix,int[] start){
			List<Integer[]> srcList = new ArrayList<>();
			List<Path> pathsList = new LinkedList<Path>();
			
			//Cell[][] cells = new Cell[matrix.length][matrix[0].length];
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix.length;j++){
					/*if(matrix[i][j]!='D'){
						cells[i][j]=new Cell(i,j,Integer.MAX_VALUE,null);
					}*/
					if(matrix[i][j]=='S'){
						Integer[] src = {i,j}; 
						srcList.add(src);
					}
				}
			}
		    for(int k=0;k<srcList.size();k++){
				Cell[][] cells = new Cell[matrix.length][matrix[0].length];
				for(int i=0;i<cells.length;i++){
					for(int j=0;j<cells.length;j++){
						if(matrix[i][j]!='D'){
							cells[i][j]=new Cell(i,j,Integer.MAX_VALUE,null);
						}
					}
				}
			LinkedList<Cell> queue = new LinkedList<>();
			Cell src = cells[srcList.get(k)[0]][srcList.get(k)[1]];
			src.dist = 0;
			src.isVisited = true;
			queue.add(src);
			Cell dest = null;
			Cell curr;
			Cell minDist=null;
			
			while((curr=queue.poll())!=null){
				if(matrix[curr.x][curr.y]=='X'){
					if(minDist==null){
						minDist = curr;
						dest = minDist;
					}
					if(curr.dist<minDist.dist){
						minDist = curr;
						dest = minDist;
					}
					else{
						dest = minDist;
						dest.dist = minDist.dist;
						
					}
				}
				visit(cells,queue,curr.x-1,curr.y,curr);
				visit(cells,queue,curr.x+1,curr.y,curr);
				visit(cells,queue,curr.x,curr.y-1,curr);
				visit(cells,queue,curr.x,curr.y+1,curr);
			}
			if(dest==null){
				return;
			}else{
				//LinkedList<Cell> path = new LinkedList<>();
				Path p = new Path();
				p.totalDist = dest.dist;
				curr = dest;
				//System.out.println(dest.dist);
				do{
					p.paths.addFirst(curr);
				}while((curr = curr.prev)!=null);
				pathsList.add(p);
				//System.out.println(path);
			}
		    }
		  //  for(Path p:pathsList){
		    pathsList.stream().forEach(p->System.out.println(p.totalDist +","+p.paths));
		    Comparator<Path> compareByMinDist = 
		    		(Path p1,Path p2)->p1.totalDist-p2.totalDist;
		    Collections.min(pathsList,compareByMinDist);
		    Path p = pathsList.stream().min(Comparator.comparing(Path::getTotalDist)).orElse(null);
		    	System.out.println(p.paths);
		    	System.out.println(p.totalDist);
		  //  }
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


