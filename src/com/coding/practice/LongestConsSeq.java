package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Input: [100, 4, 200, 1, 3, 2]
Output: 4
 * @author charan
 *
 */

public class LongestConsSeq {
	
	public static void main(String[] args){
		int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
		System.out.println(longestSeq(arr));
	}
	
	private static int longestSeq(int[] arr){
		Map<Integer,Boolean> set = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			set.put(arr[i], true);
		}
		for(Map.Entry<Integer,Boolean> m:set.entrySet()){
			while(m.getValue()){
				if(set.containsKey(m.getKey()-1)){
					int start = 
				}
			}
				
		}
	
		}
}
