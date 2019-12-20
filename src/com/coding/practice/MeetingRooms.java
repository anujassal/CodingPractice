package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {
	
	/*Input: [[0, 30],[5, 10],[15, 20]]*/
	
	static class Interval{
		int start;
		int end;
		public Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	private static int getMeetingRooms(List<Interval> list){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Comparator<Interval> interValCompare = (i1,i2)->i1.start-i2.start;
		Collections.sort(list,interValCompare);
		pq.add(list.get(0).end);
		for(int i=1;i<list.size();i++){
			Integer i1 = pq.peek();
			Interval i2 = list.get(i);
			
			if(i1!=null && i2!=null && i2.start>=pq.peek()){
				pq.remove();
			}
			pq.add(i2.end);
		}
		return pq.size();
	}
	
	public static void main(String[] args){
		/*Input: [[0, 30],[5, 10],[15, 20]]*/
		List<List<Integer>> list = new ArrayList<>();
		//List<Integer> l1 = Arrays.asList(0,30);
		//List<Integer> l2 = Arrays.asList(5,10);
		//List<Integer> l3 = Arrays.asList(15,20);
		List<Integer> l1 = Arrays.asList(7,10);
		List<Integer> l2 = Arrays.asList(2,4);
		//List<Integer> l3 = Arrays.asList(15,20);
		list.add(l1);
		list.add(l2);
		//list.add(l3);
		List<Interval> intervals = new ArrayList<>();
		list.forEach(l->{
			Interval i = new Interval(l.get(0),l.get(1));
			intervals.add(i);
		});
		System.out.println(getMeetingRooms(intervals));
	}

}
