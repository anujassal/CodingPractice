package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedian {
	
	List<Integer> list;
	
    /** initialize your data structure here. */
    public FindMedian() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
    	list.add(num);
    	Collections.sort(list);
    }
    
    public double findMedian() {
        if(list.size()>0){
        	int mid = list.size()/2;
        	if(list.size()%2==1){
        		return (list.get(mid)+list.get(mid+1))/2.0;
        	}else{
        		return list.get(mid)/2.0;
        	}	
        }
        return 0.0;
    }
    
    public static void main(String[] args){
    	FindMedian fm  = new FindMedian();
    	fm.addNum(1);
    	fm.addNum(2);
    	System.out.println(fm.findMedian());
    	fm.addNum(3);
    	System.out.println(fm.findMedian());
    }

}
