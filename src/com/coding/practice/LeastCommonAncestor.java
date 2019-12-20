package com.coding.practice;

public class LeastCommonAncestor {
	
	static class Node{
		int value;
		Node left;
		Node right;
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		public Node(int v){
			this.value = v;
		}
	}
	
	public static Node lca(Node root,int num1,int num2){
		if(root==null)
			return null;
		if(root.value==num1 || root.value==num2)
			return root;
		Node left = lca(root.left,num1,num2);
		Node right = lca(root.right,num1,num2);
		if(left!=null && right!=null)
			return root;
		if(left==null && right==null)
			return null;
		return right==null?left:right;
	}
	
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(lca(root,2,3));
	}

}
