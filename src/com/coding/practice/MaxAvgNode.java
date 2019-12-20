package com.coding.practice;

import java.util.LinkedList;

public class MaxAvgNode {
	
	static class Node{
		int key;
		LinkedList<Node> children;
		Node(){
			children = new LinkedList<>();
		}
	}
	
	static Node newNode(int key){
		Node temp = new Node();
		temp.key = key;
		return temp;
	}
	
	static int maxAvg = 0;
	static Node resultNode;
	
	static void maxAvg(Node root){
		
		if(root==null){
			return;
		}
		int count = root.children.size();
		int currSum = root.key;
		int currAvg = root.key;
		
		
		for(int i=0;i<count;i++){
			//System.out.println(root.children.get(i).key);
			currSum += root.children.get(i).key;
			maxAvg(root.children.get(i));
		}
		if(count!=0)
			currAvg = currSum/count+1;
		else
			currAvg = root.key;
		if(currAvg>maxAvg){
			resultNode = root;
			maxAvg = currAvg;
		}
		return;
	}
	
	static int getMaxAvg(Node root){
		maxAvg(root);
		return resultNode.key;
	}
	
	public static void main(String[] args){
		Node root = newNode(1);
	    (root.children).add(newNode(-5));  
	    (root.children).add(newNode(13));  
	    (root.children).add(newNode(4));  
	    (root.children.get(0).children).add(newNode(1));  
	    (root.children.get(0).children).add(newNode(2));  
	    (root.children.get(1).children).add(newNode(4));  
	    (root.children.get(1).children).add(newNode(-2));  
	    
	    System.out.println(getMaxAvg(root));
	}

}
