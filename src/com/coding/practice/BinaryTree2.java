package com.coding.practice;

import java.util.Queue; 
import java.util.LinkedList; 

public class BinaryTree2 {
	Node root;
	
	public static void main(String[] args){
		
		BinaryTree2 bt = new BinaryTree2();
		bt.root = new Node(4);
		bt.root.left = new Node(2);
		bt.root.right = new Node(5);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(3);
		//bt.root.right.left = new Node(6);
		//bt.root.right.right = new Node(7);
		//bt.printLevelOrder();
		//System.out.println(bt.maxTreeHeight(bt.root));
		//System.out.println(bt.minTreeHeight(bt.root));
		//System.out.println(bt.isBalanced(bt.root));
		//bt.printLeafNode(bt.root);
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println(bt.isBST(bt.root,max,min));
	}
	
	public boolean isBST(Node n,int max,int min){
		//a tree is BST if left subtree is BST and right subtree is bst and left node<root and right is>=root
		if(n==null)
			return true;
		if(n.data<min || n.data>max)
			return false;
		if(isBST(n.left,n.data,min) && isBST(n.right,max,n.data))
			return true;
		return false;
	}
	
	public void printLevelOrder(){

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int levelCount = 1;
		int currentCount = 0;
		while(!q.isEmpty()){
			Node temp_node = q.poll();
			if(levelCount==0){
				System.out.println();
				levelCount = currentCount;
				currentCount = 0;
			}
			if(temp_node.left!=null){
				q.add(temp_node.left);
				currentCount++;
			}
			if(temp_node.right!=null){
				q.add(temp_node.right);
				currentCount++;
			}
			System.out.print("\t"+ temp_node.data+"\t");
			levelCount--;
		}
	}
	
	public int maxTreeHeight(Node n){
		if(n==null)
			return 0;
		return 1+Integer.max(maxTreeHeight(n.left), maxTreeHeight(n.right));
	}
	
	public int minTreeHeight(Node n){
		if(n==null)
			return 0;
		return 1+Integer.min(minTreeHeight(n.left), minTreeHeight(n.right));
	}
	
	public boolean isBalanced(Node root){
		//tree is balanced if right subtree is balanced and left subtree is balanced and diff between max and min subtree heights is <=1;
		if(root==null)
			return true;
		if(isBalanced(root.left) && isBalanced(root.right) && 
				Math.abs(maxTreeHeight(root.left)-maxTreeHeight(root.right))<=1)
			return true;
		return false;
	}
	
	public void printLeafNode(Node root){
		
		if(root!=null && root.left==null && root.right==null)
			System.out.println(root.data);
		if(root!=null){
			printLeafNode(root.left);
			printLeafNode(root.right);
		}
	}

}
