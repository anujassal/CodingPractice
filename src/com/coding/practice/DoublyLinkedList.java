package com.coding.practice;


public class DoublyLinkedList {
	
	Node head;
	class Node{
		int data;
		Node next,prev;
		Node(int d){
			this.data = d;
			next = null;
			prev = null;
		}
	}
	
	public void push(int data){
		Node n = new Node(data);
		if(head==null)
			head = n;
		else{
			head.prev = n;
			n.next = head;
			head = n;
		}
		n.prev = null;	
	}
	
	public void printList(Node n){
		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void reverse(Node n){
		Node temp = null;
		while(n!=null){
			temp = n.prev;
			n.prev = n.next;
			n.next = temp;
			n = n.prev;
		}
		if(temp!=null)
			head = temp.prev;
	}
	
	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.push(2);
		list.push(4);
		list.push(8);
		list.push(10);
		System.out.println("Before reverse");
		list.printList(list.head);
		System.out.println("After Reverse");
		list.reverse(list.head);
		list.printList(list.head);
	}

}
