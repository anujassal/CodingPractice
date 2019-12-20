package com.coding.practice;
/*
 * Input: [-10,9,20,null,null,15,7]
 */

public class MaxSumPath {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int v){
			this.data = v;
		}
	}
	
	public static void main(String[] args){
		Node root = new Node(-10);
		Node n1 = new Node(9);
		Node n2 = new Node(20);
		Node n3 = new Node(15);
		Node n4 = new Node(7);
		root.left = n1;
		root.right = n2;
		root.right.left = n3;
		root.right.right = n4;
		System.out.println(findMaxSum(root));
		
	}
	
	private static int findMaxSum(Node root){
		int result = 0;
		if(root==null){
			return 0;
		}
		int left = findMaxSum(root.left);
		int right = findMaxSum(root.right);
		int maxPathSum = Math.max(root.data, Math.max(left,right)+root.data);
		int maxSumSubtreeVsPath = Math.max(maxPathSum, root.data+left+right);
		result = Math.max(result,maxSumSubtreeVsPath);
		return result;
	}

}
