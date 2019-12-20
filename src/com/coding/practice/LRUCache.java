package com.coding.practice;

import java.util.LinkedHashMap;
import java.util.Map;
//https://www.callicoder.com/java-linkedhashmap/
/**
 * Linked hashmap maintains the order in which the elements are inserted. So when we do map.getKeySet().iterator.next 
 * we get the next least recently used element.
 * @author charan
 *
 */
public class LRUCache {
	
	Map<Integer,Integer> map;
	private  int capacity;
	
	LRUCache(int cap){
		capacity = cap;
		map = new LinkedHashMap<>();
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			int value = map.get(key);
			map.remove(key);
			map.put(key,value);
			return value;
		}
		return -1;	
	}
	
	public void put(int key,int value) {
		if(map.containsKey(key)) {
			map.remove(key);
		}else {
		if(map.size()==2) {
			map.remove(map.keySet().iterator().next());
		}
		}
		map.put(key,value);
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
	
	

}
