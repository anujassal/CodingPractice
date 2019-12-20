package com.coding.practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
	
	private static Map<Integer,Integer> map = new LinkedHashMap<>();
	private int capacity;
	
	public LRUCache2(int size) {
		capacity = size;
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		int i = map.get(key);
		map.remove(key);
		map.put(key,i);
		return i;
	}
	
	public void put(int key,int value) {
		if(map.size()>=capacity) {
			Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
			map.remove(it.next().getKey());
		}
		map.put(key,value);
	}
	
	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(2);
		
		cache.put(1,1);
		cache.put(2,2);
		System.out.println(cache.get(1)); //1
		cache.put(3,3);
		System.out.println(cache.get(2)); //-1
		cache.put(4,4);
		System.out.println(cache.get(1)); //-1
		System.out.println(cache.get(3)); //3
		System.out.println(cache.get(4)); //4
	}

}
