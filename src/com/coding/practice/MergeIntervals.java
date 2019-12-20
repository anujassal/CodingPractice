package com.coding.practice;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
	
	static class Interval{
		int start;
		int end;
		Interval(int s,int e){
			this.start = s;
			this.end = e;
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args){
		
	}
	
	public static List<Interval> mergeIntervals(List<Interval> list){
		PriorityQueue<Interval> pq = new PriorityQueue<>();
		for(int i=0;i<list.size()-1;i++){
			pq.add(list.get(i));
		}
		while(pq.size()>0){
			Interval i1 = pq.poll();
			Interval i2 = pq.poll();
			if(i1.)
		}
	}
	
	private static Node merge(Node n1,Node n2,List<Node> list){
		Interval i = new Interval(n1.i.start,n2.i.end);
		Node n = new Node(i);
		n.next = n2.next;
		
		return n;
	}

}
