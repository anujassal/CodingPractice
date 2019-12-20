package com.coding.practice;

public class BinaryTree {

	public static boolean isBalanced(Node n){
		
		if(n==null)
			return true;
		int lh = height(n.left);
		int rh = height(n.right);
		
		if(Math.abs(lh-rh)<=1 && isBalanced(n.left) && isBalanced(n.right))
			return true;
		return false;
	}
	
	public static int height(Node n){
		
		if(n==null)
			return 0;
		
		return 1+ Integer.max(height(n.left), height(n.left));
	}
}
