package com.coding.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.coding.practice.BFS.Node;

public class FindMaxAtEveryLevelBT {
	
	static class Node{
		int data;
		Node left;
		Node right;
		int level;
		Node(int d){
			this.data = d;
		}
	}
	
	static class Level{
		int max;
		int level;
		Level(int l){
			this.level = l;
		}
	}
	
	private static void findMax(Node root){
		Queue<Node> q = new LinkedList<>();
		Map<Integer,Integer> levelToMax = new HashMap<>();
		root.level = 1;
		levelToMax.put(root.level, root.data);
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node n = q.poll();
			if(n!=null){
			if(n.left!=null){
				n.left.level = n.level + 1;
				if(levelToMax.containsKey(n.left.level)){
					if(n.left.data>levelToMax.get(n.left.level))
						levelToMax.put(n.left.level, n.left.data);
				}else{
					levelToMax.put(n.left.level, n.left.data);
				}
				q.add(n.left);
			}
			if(n.right!=null){
				n.right.level = n.level + 1;
				if(levelToMax.containsKey(n.right.level)){
					if(n.right.data>levelToMax.get(n.right.level))
						levelToMax.put(n.right.level, n.right.data);
				}else{
					levelToMax.put(n.right.level, n.right.data);
				}
				q.add(n.right);
			}
			
			}else{
				if(!q.isEmpty())
					q.add(null);
			}
		}
		for(Map.Entry<Integer, Integer> m:levelToMax.entrySet()){
			System.out.println("Level-> " + m.getKey() +" max Value-> " + m.getValue());
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
		findMax(root);
		
	}

}
