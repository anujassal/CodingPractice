package com.coding.practice;
/**
 * 
 * @author charan
 * 2->4->3 + 5->6->4 = 7->0->8
 *
 */

public class AddTwoNumbers {
	
	static class Node{
		public int data;
		public Node next;
		public Node(int i){
			this.data = i;
		}
	}
	
	static class LinkedList{
		Node first;
		//utility methods go here - insert, delete, iterate
		public void insertAtEnd(int data){
			Node current = first;
			if(current!=null){
				while(current.next!=null)
					current = current.next;
			}else{
				Node n = new Node(data);
				first = n;
				return;
			}
			current.next = new Node(data);
		}
		
		public void print(){
			Node current = first;
			while(current.next!=null){
				System.out.println(current.data);
				current = current.next;
			}
			System.out.println(current.data);
		}
	}
	
	private LinkedList getSum(Node n1,Node n2){
		int carry=0;
		LinkedList list = new LinkedList();
		while(n1!=null && n2!=null){
			int sum = n1.data + n2.data + carry;
			int remainder = sum%10;
			carry = sum/10;
			list.insertAtEnd(remainder);
			n1 = n1.next;
			n2 = n2.next;
		}
		return list;
	}
	
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(2);
		list1.insertAtEnd(4);
		list1.insertAtEnd(3);
		
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(5);
		list2.insertAtEnd(6);
		list2.insertAtEnd(4);
		
		AddTwoNumbers addNumbers = new AddTwoNumbers();
		LinkedList newList = addNumbers.getSum(list1.first, list2.first);
		newList.print();
	}
	
	
	
	
	
	

}
