package com.coding.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomScheduling {
	
	static class Interval{
		int start;
		int end;
		Interval(int s,int e){
			this.start = s;
			this.end = e;
		}
	}
	
	public static int minMeetingRoomCount(Interval[] intervals){
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		Comparator<Interval> intervalComparator = (Interval i1,Interval i2)->i1.start-i2.start;
		Arrays.sort(intervals,intervalComparator);
		pQueue.add(intervals[0].end);
		for(int i=1;i<intervals.length;i++){
			Interval curr = intervals[i];
			if(curr.start>=pQueue.peek())
				pQueue.remove();
			pQueue.add(curr.end);
		}	
		return pQueue.size();
	}
	
	public static void main(String[] args){
		Interval[] intervals = {new Interval(0,30),new Interval(5,10),new Interval(15,20)};
		System.out.println(minMeetingRoomCount(intervals));
	}

}
