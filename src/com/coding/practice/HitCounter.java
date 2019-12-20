package com.coding.practice;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	/**
	 * keep storing the timestamp in a list. every time a hot happens, calculate the curr timestamp-prev 
	 * timestamp in the list for all the elements in the list. If the diff is > 300 then subtract from the counter
	 * and remove that timestamp from the list.
	 */
	
	private Queue<Integer> prevTimeStampList;
	
	 /** Initialize your data structure here. */
    public HitCounter() {
    	prevTimeStampList = new LinkedList<>(); 
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    	compress(timestamp);
    	prevTimeStampList.add(timestamp);    
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	compress(timestamp);
    	return prevTimeStampList.size(); 
    }
    
    public void compress(int timestamp) {
    	while(prevTimeStampList.size()>0 && timestamp-prevTimeStampList.peek()>=300) {
    		prevTimeStampList.poll();
    	}
    }
    
    public static void main(String[] args) {
    	HitCounter counter = new HitCounter();

    	// hit at timestamp 1.
    	counter.hit(2);

    	// hit at timestamp 2.
    	counter.hit(3);

    	// hit at timestamp 3.
    	counter.hit(4);

    	// get hits at timestamp 4, should return 3.
    	System.out.println(counter.getHits(300));
    	System.out.println(counter.getHits(301));
    	System.out.println(counter.getHits(302));
    	System.out.println(counter.getHits(303));
    	System.out.println(counter.getHits(304));

    	// get hits at timestamp 300, should return 4.
    	counter.hit(501);

    	// get hits at timestamp 301, should return 3.
    	System.out.println(counter.getHits(600)); 

    	/*["HitCounter","hit","hit","hit","getHits","getHits","getHits","getHits","getHits","hit","getHits"]
    			[[],[2],[3],[4],[300],[301],[302],[303],[304],[501],[600]]

[null,null,null,null,3,3,2,0,-3,null,-5]
Expected
[null,null,null,null,3,3,2,1,0,null,1]*/
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

