package com.coding.practice;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
	
	static class Node{
		Node right;
		Node left;
		int value;
		public Node(int v) {
			value = v;
		}
	}
	
	public static String serialize(Node node,String str) {
		if(node==null) {
			return str + "null"+",";
		}
		str = str + String.valueOf(node.value)+",";
		str = serialize(node.left,str);
		str = serialize(node.right,str);
		return str;
	}
	
	public static Node deserialize(Queue<String> queue) {
		String str = queue.poll();
		if(str == "null") {
			return null;
		}
		Node node = new Node(Integer.valueOf(str));
		node.left = deserialize(queue);
		node.right = deserialize(queue);
		return node;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		String str = serialize(root,"");
		String[] strArray = str.split(",");
		Queue<String> queue = new LinkedList<>();
		for(String s:strArray) {
			queue.offer(s);	
		}
		System.out.println(str);
	}

}
