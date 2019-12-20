package com.coding.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequentWords2 {
	
	public static void main(String[] args){
		String[] arr = new String[]{"i","love","leetcode","i","love","coding"};
		getTopFrequentWords(arr,2);
	}
	
	private static void getTopFrequentWords(String[] arr,int k){
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0));
		}
		
		PriorityQueue<String> queue = new PriorityQueue<String>(
				(w1,w2)->map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1):map.get(w1) - map.get(w2));
		for(Map.Entry<String,Integer> e:map.entrySet()){
			queue.add(e.getKey());
		}
		while(queue.size()>k){
			queue.poll();
		}
		queue.forEach(e->System.out.println(e));
	}

}
