package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class RoboPath {
	
	
	static List<Point> currentPath = new ArrayList<>();
	
	static class Point{
		int x;
		int y;
		Point(int x1,int y1){
			x = x1;
			y = y1;
		}
	}

	
	public static boolean getPaths(int x,int y) {
		Point p = new Point(x,y);
		currentPath.add(p);
		if(x==0&&y==0) {
			return true;
		}
		boolean success = false;
		if(x>=1 && is_free(x-1,y)) {
			success = getPaths(x-1,y);
		}
		if(!success&&y>=1&&is_free(x,y-1)) {
			success = getPaths(x,y-1);
		}
		if(!success) {
			currentPath.remove(p);
		}
		return success;
	}
	
	public static boolean is_free(int x,int y) {
		return true;
	}

}
