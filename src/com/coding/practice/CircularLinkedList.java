package com.coding.practice;

import java.util.HashSet;

public class CircularLinkedList {
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(10);
		ListNode n2 = new ListNode(20);
		ListNode n3 = new ListNode(30);
		ListNode n4 = new ListNode(40);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
		removeCircularNode(n1);
		ListNode currNode = n1;
		System.out.println(currNode.data);
		while(currNode!=null){
			if(currNode.next!=null)
				System.out.println(currNode.next.data);
			currNode = currNode.next;
		}
	}
	
	public static void removeCircularNode(ListNode root){
		HashSet<Integer> set = new HashSet<>();
		ListNode currNode = root;
		ListNode prevNode = root;
		while(currNode!=null){
			if(set.contains(currNode.data)){
				 prevNode.next = null;
				 break;
			}
			else{
				set.add(currNode.data);
			}
			prevNode = currNode;
			currNode = currNode.next;
			
		}
		
	}

}
