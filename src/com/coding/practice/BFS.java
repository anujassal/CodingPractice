package com.coding.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	static class Node{
		int val;
		Node right;
		Node left;
		Node next;
		int level;
		Node(int value){
			this.val = value;
		}
	}
	
	public static void bfs(Node root){
		if(root==null)
			return;
		Queue<Node> queue = new LinkedList<>();
		root.level = 0;
		queue.add(root);
		while(!queue.isEmpty()){
			Node n = queue.remove();
			System.out.println(n.val + " level-> " + n.level);
			if(n.left!=null){
				n.left.level = n.level+1;
				n.left = n.right;
				queue.add(n.left);
			}
			if(n.right!=null){
				n.right.level = n.level+1;
				queue.add(n.right);
			}
		}	
	}
	
	public static void main(String[] args){
		
		Node root = new Node(1);
		Node n1 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n7 = new Node(7);
		root.left = n1;
		root.right = n3;
		root.left.left = n4;
		root.left.right = n5;
		root.right = n3;
		root.right.right = n7;
		bfs(root);
	}
}
