package com.coding.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeTree {
	
	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int v){
			value = v;
		}
	}
	
	public static void serialize(TreeNode root,List<String> builder){
		if(root==null){
			builder.add("null");
			return;
		}
		
		builder.add(String.valueOf(root.value));
		serialize(root.left,builder);
		serialize(root.right,builder);

		//String serializedTree = root.value + serialize(root.left,builder) + serialize(root.right,builder)
	}
	
	public static TreeNode deserialize(Queue<TreeNode> q){
		TreeNode n = q.poll();
		if(n==null){
			return null;
		}
		n.left = deserialize(q);
		n.right = deserialize(q);
		return n;
	}
	
	public static TreeNode deserialize(List<String> s){
		Queue<TreeNode> q = new LinkedList<>();
		for(int i=0;i<s.size();i++){
			
			if(!s.get(i).equals("null"))
				q.add(new TreeNode(Integer.valueOf(s.get(i))));
			else
				q.add(null);	
		}

		return deserialize(q);
	}
	
	public static void main(String[] args){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<String> builder = new LinkedList<>();
		serialize(root,builder);
		System.out.println(builder);
		TreeNode n = deserialize(builder);
		List<String> builder2 = new LinkedList<>();
		serialize(n,builder2);
		System.out.println(builder2);
		
		
	}

}
