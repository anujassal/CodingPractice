package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {
	
	class Node{
		T key;
		int weight;
	}
	
	List<Node> allNodes = new ArrayList<>();
	//map of where the node/key lies in the array
	Map<T,Integer> nodePositionInArray = new HashMap<>();
	/*
	 * BinaryHeap will have following methods-
	 * -add - add new nodes
	 * -decrease - decrease the weight of the node in the heap
	 * -extractMin - extract the min node -> allNodes.get(0)
	 */
	
	public void add(T key,int weight){
		Node n = new Node();
		n.key = key;
		n.weight = weight;
		allNodes.add(n);
		int size = allNodes.size() - 1;
		/*find the parent of this node and compare the value of parent with the 
		current to identify if we need to adjust the tree
		parentIdx = (i-1)/2
		leftIdx = (2i+1)/2
		rightIdx = (2i+2)/2
		a new node will always be added to the leftmost/end of the array
		*/
		int currIndex = size;
		nodePositionInArray.put(n.key, currIndex);
		int parentIndex = (currIndex-1)/2;
		while(parentIndex>=0){
			Node parent = allNodes.get(parentIndex);
			Node current = allNodes.get(currIndex);
			if(parent.weight>current.weight){
				swap(parent,current);
				updateNodePosition(parent,current,parentIndex,currIndex);
				currIndex = parentIndex;
				parentIndex = (currIndex-1)/2;
			}else
				break;
		}
	}
	
	public void decrease(T n,int newWeight){
		int currIndex = nodePositionInArray.get(n);
		Node currNode = allNodes.get(currIndex);
		currNode.weight = newWeight;
		int parentIndex = (currIndex-1)/2;
		while(parentIndex>=0){
			Node parent = allNodes.get(parentIndex);
			Node current = allNodes.get(currIndex);
			if(parent.weight>current.weight){
				swap(parent,current);
				updateNodePosition(parent,current,parentIndex,currIndex);
				currIndex = parentIndex;
				parentIndex = (currIndex-1)/2;
			}else
				break;
		}
	}
	
	public Integer getWeight(T key){
		Integer index = nodePositionInArray.get(key);
		if(index==null)
			return null;
		return allNodes.size()!=0&&allNodes.get(index)!=null?allNodes.get(index).weight:null;
	}
	
	public Node extractMin(){
		//make a new node and of the first node.
		Node min = new Node();
		min.key = allNodes.get(0).key;
		min.weight = allNodes.get(0).weight;
		int size = allNodes.size()-1;
		int lastNodeWeight = allNodes.get(size).weight;
		//now copy the contents of last node to first node.
		allNodes.get(0).key = allNodes.get(size).key;
		allNodes.get(0).weight = lastNodeWeight;
		//remove first and last keys from the binary heap and add the new position of the key to the heap.
	    nodePositionInArray.remove(min.key);
	    nodePositionInArray.remove(allNodes.get(0));
	    nodePositionInArray.put(allNodes.get(0).key, 0);
	    //lastly remove the last key from the array.
		allNodes.remove(size);
		int currIndx = 0;
		size--;
		while(true){
			int left = 2*(currIndx)+1;
		    int right = 2*(currIndx)+2;
		    if(left>size)
		    	break;
		    if(right>size)
		    	right = left;
		    int smallerIndx = left<right?left:right;
		    if(allNodes.get(smallerIndx).weight<allNodes.get(currIndx).weight){
		    	swap(allNodes.get(currIndx),allNodes.get(smallerIndx));
		    	updateNodePosition(allNodes.get(currIndx),allNodes.get(smallerIndx),currIndx,smallerIndx);
		    	currIndx = smallerIndx;
		    }else
		    	break;
		}
		return min;
	}
	
	public boolean contains(T key){
		return nodePositionInArray.containsKey(key);
	}
	
	public T getMin(){
		return extractMin().key;
	}
	
	public boolean isEmpty(){
		return allNodes.size()==0;
	}
	
	private void swap(Node n1,Node n2){
		T tempKey = n1.key;
		int tempWtg = n1.weight;
		n1.key = n2.key;
		n1.weight = n2.weight;
		n2.key = tempKey;
		n2.weight = tempWtg;
	}
	
	private void updateNodePosition(Node n1, Node n2, int idx1,int idx2){
		nodePositionInArray.put(n1.key, idx1);
		nodePositionInArray.put(n2.key, idx2);
	}
	
	private void printArray(){
		nodePositionInArray.forEach((key,value)->System.out.println(key +","+value));
	}
	
	public static void main(String[] args){
		BinaryMinHeap<String> heap = new BinaryMinHeap<>();
		heap.add("A",10);
		heap.add("B",8);
		heap.add("G",1);
		heap.add("C",6);
		heap.add("F",2);
		heap.add("D",5);
		heap.add("E",4);
		//System.out.println(heap.printArray());
		System.out.println(heap.getMin());
	}

}
