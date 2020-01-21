package com.coding.practice;

public class ValidBinarySearchTree {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int v) {
			value = v;
		}
	}

	public static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}
		if ((root.left != null && root.left.value >= root.value)
				|| (root.right != null && root.right.value <= root.value)) {
			return false;
		} else {
			return isBST(root.left) && isBST(root.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.right.left = new Node(1);
		root.right.right = new Node(6);
		System.out.println(isBST(root));
	}
}
