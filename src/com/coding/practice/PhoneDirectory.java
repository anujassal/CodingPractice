package com.coding.practice;

import java.util.LinkedList;
import java.util.List;

public class PhoneDirectory {
	
	List<Integer> list = new LinkedList<>();
	
	
	int get() {
		
		return list.remove(0);
	}
	
	boolean check(int num) {
		
		return list.contains(num);
		
	}
	
	boolean release(int num) {
		if(!list.contains(num)) {
			list.add(num);
			return true;
		}
		return false;
		
	}

}
