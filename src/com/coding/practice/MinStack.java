package com.coding.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class MinStack {
	
	private List<Integer> linkedList = new LinkedList<>();
	private PriorityQueue<Integer> q = new PriorityQueue<>();
	
	public void push(int x){
		linkedList.add(x);
		q.add(x);
	}
	
	public int top(){
		if(!linkedList.isEmpty())
			return linkedList.get(linkedList.size()-1);
		return -1;		
	}
	
	public void pop(){
		if(!linkedList.isEmpty()){
			int x = linkedList.remove(linkedList.size()-1);
			q.remove(Integer.valueOf(x));
		}
	}
	
	public int getMin(){
		int x = q.peek();
		return x;	
	}
	
	public static void main(String[] args){
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

}
