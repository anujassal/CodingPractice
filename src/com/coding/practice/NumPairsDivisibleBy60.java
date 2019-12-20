package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumPairsDivisibleBy60 {
	
	public static int bruteForce(int[] time){
		List<List<Integer>> allPairs = new ArrayList<>();
		for(int i=0;i<time.length;i++) {
			for(int j=i+1;j<time.length;j++) {
				if((time[i]+time[j])%60==0) {
					List<Integer> list = new ArrayList<>();
					list.add(time[i]);
					list.add(time[j]);
					allPairs.add(list);
				}
			}
		}
		return allPairs.size();
	}
	//(time[i] + time[j]) % 60 == 0
	public static int usingMap(int[] time) {
		Map<Integer,Integer> map = new HashMap<>();
		int count = 0;
		for(int i=0;i<time.length;i++) {
			int n = (60 - time[i]%60) % 60;
			if(map.containsKey(n))
				count += map.getOrDefault(n, 0);
			map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
		}
		return count;
		
		/*HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		for(int t : time) {
			count +=  hm.getOrDefault((60 - t % 60) % 60, 0);
			hm.put(t%60, hm.getOrDefault(t%60,0)+1);
		}        
		return count;*/
	}
	
	public static void main(String[] args) {
		int[] time = {30,20,150,100,40};
		System.out.println(bruteForce(time));
		System.out.println(usingMap(time));
	}
}
