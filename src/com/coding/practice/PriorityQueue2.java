package com.coding.practice;


public class PriorityQueue2 {

	private final int SIZE = 20;
	private Edge<Node>[] queArray;
	private int size;
	
	//TODO
	/*
	public PriorityQueue2(){
		queArray = new Edge[SIZE];
		size = 0;
	}
	
	public void insert(Edge item){
		int j;
		for(j=0;j<size;j++)
			if(item.distance >= queArray[j].distance)
				break;
		for(int k=size-1;k>=j;k--)
			queArray[k+1] = queArray[k];
		queArray[j] = item;
		size++;
	}
	
	public Edge removeMin(){
		return queArray[--size];
	}
	
	public void removeN(int n){
		for(int j=n;j<size;j++){
			queArray[j] = queArray[j+1];
		size--;
		}
	}*/
	
}
