package com.coding.practice;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		ListNode l1n1 = new ListNode(1);
		ListNode l1n2 = new ListNode(4);
		ListNode l1n3 = new ListNode(5);
		l1n1.next = l1n2;
		l1n2.next = l1n3;
		lists[0] = l1n1;
		
		ListNode l2n1 = new ListNode(1);
		ListNode l2n2 = new ListNode(3);
		ListNode l2n3 = new ListNode(4);
		l2n1.next = l2n2;
		l2n2.next = l2n3;
		lists[1] = l2n1;
		
		ListNode l3n1 = new ListNode(2);
		ListNode l3n2 = new ListNode(6);
		l3n1.next = l3n2;
		lists[2] = l3n1;
		
		ListNode res = mergeKLists(lists);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(ListNode node:lists) {
			while(node!=null) {
				minHeap.add(node.val);
				node = node.next;
			}
		}
		ListNode dummy = new ListNode(-1);
		ListNode n = dummy;
		while(!minHeap.isEmpty()) {	
			n.next = new ListNode(minHeap.poll());
			n = n.next;
		}
		return dummy.next;
	}

}
