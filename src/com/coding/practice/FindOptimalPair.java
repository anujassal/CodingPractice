package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindOptimalPair {
	
	static class OptimalPair{
		int backGroundId;
		int backGroundSpace;
		int foreGroundId;
		int foreGroundSpace;
		int maxSpace;
		OptimalPair(int backGroundId,int backGroundSpace,int foreGroundId,int foreGroundSpace){
			this.backGroundId = backGroundId;
			this.backGroundSpace = backGroundSpace;
			this.foreGroundId = foreGroundId;
			this.foreGroundSpace = foreGroundSpace;
		}
	}
	
	public static void main(String[] args){
		//[1,8][2,7][3,14]
		List<List<Integer>> foregroundAppList = new ArrayList<>();
		List<Integer> pair1 = new ArrayList<>();
		pair1.add(1);
		pair1.add(8);
		foregroundAppList.add(pair1);
		List<Integer> fpair2 = new ArrayList<>();
		fpair2.add(2);
		fpair2.add(7);
		foregroundAppList.add(fpair2);
		List<Integer> fpair3 = new ArrayList<>();
		fpair3.add(3);
		fpair3.add(14);
		foregroundAppList.add(fpair3);
		
		
		
		List<List<Integer>> backgroundAppList = new ArrayList<>();
		List<Integer> bpair1 = new ArrayList<>();
		//[1,5][2,10][3,14]
		bpair1.add(1);
		bpair1.add(5);
		backgroundAppList.add(bpair1);
		List<Integer> bfpair2 = new ArrayList<>();
		bfpair2.add(2);
		bfpair2.add(10);
		backgroundAppList.add(bfpair2);
		List<Integer> bfpair3 = new ArrayList<>();
		bfpair3.add(3);
		bfpair3.add(14);
		backgroundAppList.add(bfpair3);
		FindOptimalPair t = new FindOptimalPair();
		List<List<Integer>> optimalPairs = t.optimalUtilization(10,foregroundAppList,backgroundAppList);
		for(int i=0;i<optimalPairs.size();i++){
			for(int j=0;j<optimalPairs.get(i).size()-1;j++){
				System.out.println("[("+optimalPairs.get(i).get(1)+","+optimalPairs.get(i).get(j+1)+")]");
			}
		}
	}
	
	    public List<List<Integer>> optimalUtilization(
		                        int deviceCapacity, 
	                            List<List<Integer>> foregroundAppList,
	                            List<List<Integer>> backgroundAppList)
		{
	        int maxSum = 0;
	        List<OptimalPair> pair = Collections.EMPTY_LIST;
	        for(int i=0;i<foregroundAppList.size();i++){
	            for(int j=0;j<backgroundAppList.size();j++){
	                //get the second integer from the list
	                int newSum = foregroundAppList.get(i).get(1) + backgroundAppList.get(j).get(1);
	                if(newSum<=deviceCapacity){
	                    if(maxSum < newSum){
	                    	int fgId = foregroundAppList.get(i).get(0);
	                    	int bgId = backgroundAppList.get(j).get(0);
	                    	int fgSpace = foregroundAppList.get(i).get(1);
	                    	int bgSpace = backgroundAppList.get(j).get(1);
	                    	OptimalPair oPair = new OptimalPair(fgId,fgSpace,bgId,bgSpace);
	                    	oPair.maxSpace = newSum;
	                        maxSum = newSum;
	                        pair = new ArrayList<>();
	                        pair.add(oPair);
	                       // pair.add(foregroundAppList.get(i).get(0));
	                        //pair.add(backgroundAppList.get(j).get(0)); 
	                    }
	                }
	            }
	        }
	        int maxSpace = maxSum;
	           List<List<Integer>> pairWithMaxSpace = new ArrayList<>();
	           List<OptimalPair> maxSpaceOptimalPair = pair.stream().filter(op->op.maxSpace==maxSpace).collect(Collectors.toList());
	           for(OptimalPair p:maxSpaceOptimalPair){
	        	   List<Integer> newPair = new ArrayList<>();
	        	   newPair.add(p.foreGroundId);
	        	   newPair.add(p.backGroundId);
	        	   pairWithMaxSpace.add(newPair);
	           }
	           return pairWithMaxSpace; 
	    }

}

