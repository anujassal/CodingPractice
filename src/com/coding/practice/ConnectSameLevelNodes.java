package com.coding.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNodes {
	
	static class Node{
		int data;
		Node right;
		Node left;
		Node nextRight;
		Node(int v){
			this.data = v;
		}
	}
	
	public static void main(String[] args){
        Node root = new Node(10); 
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.right.right = new Node(90); 
       
        // Populates nextRight pointer in all nodes 
        connect(root); 
        System.out.println("Following are populated nextRight pointers in \n" + 
        	      "the tree (-1 is printed if there is no nextRight)"); 
        	        System.out.println("nextRight of "+ root.data +" is "+ 
        	        ((root.nextRight != null) ? root.nextRight.data : -1)); 
        	        System.out.println("nextRight of "+ root.left.data+" is "+ 
        	        ((root.left.nextRight != null) ? root.left.nextRight.data : -1)); 
        	        System.out.println("nextRight of "+ root.right.data+" is "+ 
        	        ((root.right.nextRight != null) ? root.right.nextRight.data : -1)); 
        	        System.out.println("nextRight of "+  root.left.left.data+" is "+ 
        	        ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1)); 
        	        System.out.println("nextRight of "+  root.right.right.data+" is "+ 
        	        ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1)); 
        	     
	}
	
	private static void connect(Node root){
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node n1 = q.poll();
			if(n1!=null){
				if(n1.left!=null)
					q.add(n1.left);
				if(n1.right!=null)
					q.add(n1.right);
				Node n2 = q.peek();
				n1.nextRight = n2;
			}else if(!q.isEmpty()){
				q.add(null);
			}	
		}
	}

}
