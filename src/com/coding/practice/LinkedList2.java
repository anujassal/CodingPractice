package com.coding.practice;


public class LinkedList2 {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			next = null;
		}
	}
	
	public void push(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}
	
	public void append(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
			return;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = n;
	}
	
	//TODO
	public void insertAfter(int data,Node prev){
		Node n = new Node(data);
		if(head==null)
			head = n;
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = n;
	}
	
	public Node reverseList(Node curr){
		//make first node point to null but then
		//need pointer next so that ref to the list of not lost
		//make the next node point to the prev so reference to prev is not lost.
		Node prev = null;
		Node next = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public int min(Node n){
		int min = n.data;
		while(n!=null){
			if(n.data<min)
				min = n.data;
			n = n.next;
		}
		return min;	
	}
	
	public static void main(String[] args){
		LinkedList2 list = new LinkedList2();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		System.out.print(list.min(list.head));
		/*Node curr = list.head;
		System.out.println("Before Reverse");
		while(curr!=null){
			System.out.println(curr.data);
			curr = curr.next;
		}
		curr = list.reverseList(list.head);
		System.out.println("After Reverse");
		while(curr!=null){
			System.out.println(curr.data);
			curr = curr.next;
		}*/
	}
	
	

}
