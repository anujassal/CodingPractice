package com.coding.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CountCompleteTreeNodes {
	
	class TreeNode{
		int root;
		TreeNode left;
		TreeNode right;
		TreeNode(int value){
			root = value;
		}
	}
	
	public static void main(String[] args){
		
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		
		TreeNode root = c.new TreeNode(1);
		root.left = c.new TreeNode(2);
		root.right = c.new TreeNode(3);
		root.left.left = c.new TreeNode(4);
		root.left.right = c.new TreeNode(5);
		root.right.left = c.new TreeNode(6);
		
		System.out.println(count(root));
		System.out.println(linearCount(root));
	}
	
	//O(V+E)
	private static int count(TreeNode node){
		Queue<TreeNode> q = new LinkedList<>();
		int count = 0;
		if(node!=null)
			q.add(node);
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			count++;
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
		return count;
	}
	
	private static int linearCount(TreeNode root){
		return root!=null?linearCount(root.left)+1+linearCount(root.right):0;
	}
	
	
}
