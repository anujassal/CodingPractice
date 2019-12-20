package com.coding.practice;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode first=null;
		ListNode currNode = null;
		if(l1==null && l2!=null)
			return l2;
		if(l1!=null && l2==null)
			return l1;
		if(l1==null && l2==null)
			return null;
		
		while(l1!=null && l2!=null){
			ListNode newNode;
			if(l1.data>=l2.data){
				newNode = new ListNode(l2.data);
				l2 = l2.next;
			}
			else{
				newNode = new ListNode(l1.data);
				l1 = l1.next;
			}
			if(first==null){
				first = newNode;
				currNode = first;
			}else{
				currNode.next = newNode;
			    currNode = currNode.next;
			}
		}
		while(l1!=null){
			ListNode newNode = new ListNode(l1.data);
			l1=l1.next;
			currNode.next = newNode;	
			currNode = currNode.next;
		}
		while(l2!=null){
			ListNode newNode = new ListNode(l2.data);
			l2=l2.next;
			currNode.next = newNode;
			currNode = currNode.next;
		}
		return first;
    }
	
	public static void main(String[] args){
		//1->2->4, 1->3->4
		ListNode first1 = new ListNode(1);
		first1.next = new ListNode(2);
		first1.next.next = new ListNode(4);
		first1.next.next.next = new ListNode(10);
		first1.next.next.next.next = null;
		first1=null;
		
		ListNode first2 = new ListNode(1);
		first2.next = new ListNode(5);
		first2.next.next = new ListNode(9);
		first2.next.next.next = null;
		
		ListNode node = mergeTwoLists(first1,first2);
		while(node!=null){
			System.out.println(node.data);
			node = node.next;
		}
		
	}

}
