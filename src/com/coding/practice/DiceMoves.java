package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceMoves {
	
	
	public static void main(String[] args){
		Map<Integer,List<Integer>> map = new HashMap<>();
		List<Integer> intList1 = new ArrayList<>(Arrays.asList(0,1,1,1,1,2));
		map.put(1, intList1);
		List<Integer> intList2 = new ArrayList<>(Arrays.asList(1,0,1,1,2,1));
		map.put(2, intList2);
		List<Integer> intList3 = new ArrayList<>(Arrays.asList(1,1,0,2,1,1));
		map.put(3, intList3);
		List<Integer> intList4 = new ArrayList<>(Arrays.asList(1,1,2,0,1,1));
		map.put(4, intList4);
		List<Integer> intList5 = new ArrayList<>(Arrays.asList(1,2,1,1,0,1));
		map.put(5, intList5);
		List<Integer> intList6 = new ArrayList<>(Arrays.asList(2,1,1,1,1,0));
		map.put(6, intList6);
		int[] arr = {1,1,1}; 
		System.out.println(getMovesCount(map,arr));
	}
	
	public static int getMovesCount(Map<Integer,List<Integer>> map,int[] arr){
		int moves = 0;
		int i=0;
		int minMove = 0;
		while(i<arr.length){
		for(int j=0;j<arr.length;j++){
			if(arr[j]==arr[i]||i==j)
				continue;
			moves = moves + map.get(arr[j]).get(arr[i]-1);
		}
		minMove = (minMove<moves&&i!=0) ? minMove:moves;
		moves = 0;
		i++;
		}
		return minMove;
	}

}
