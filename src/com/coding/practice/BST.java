package com.coding.practice;

public class BST {
	
	class Node{
		int value;
		Node right;
		Node left;
		Node(int v){
			this.value = v;
		}
	}
	
	public static void main(String[] args){
		
	}
	
	private int maxDepth(Node root){
		if(root==null)
			return 0;
		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	
	private int minDepth(Node root){
		if(root==null)
			return 0;
		return 1+Math.min(minDepth(root.left),minDepth(root.right));
	}

	private boolean isBalanced(Node root){
		return (maxDepth(root)-minDepth(root)<=1);
	}
}
