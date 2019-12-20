package com.coding.practice;


public class LinkedList3 {
	
	ListNode first;
	
	LinkedList3(ListNode root){
		this.first = root;
	}
	
	public void insert(int data){
		ListNode node = new ListNode(data);
		if(first==null)
			first = node;
		else{
			ListNode currNode = first;
			ListNode prevNode = first;
		
			while(currNode!=null){
				prevNode = currNode;
				currNode= currNode.next;
			}
			prevNode.next = node;
		}	
	}

	public void delete(int d){
		ListNode currNode = first;
		ListNode prevNode = first;
		while(currNode!=null && currNode.data!=d){
			prevNode = currNode;
			currNode = currNode.next;
		}
		if(currNode==null){
			System.out.println("Node not found");
		}
		else{
			prevNode.next = currNode.next;
		}
	}
	
	public void iterate(Node n){
		
	}
}
