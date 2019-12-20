package com.coding.practice;

import java.util.List;

public class SumOfWeights {
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
		TreeNode(int v){
			value = v;
		}
	}
	
	public static void main(String[] args){
		TreeNode node = new TreeNode(4);
		
		
		System.out.println(getWeightedSum());
	}
	
	private static int getWeightedSum(TreeNode node,List<Integer> sumList){
		
		if(node==null)
			return 0;
		if(node!=null && node.left==null && node.right==null){
			return node.value;
		}
		int curr_sum = getWeightedSum(node.left,sumList)+getWeightedSum(node.right,sumList)+node.value;
		return curr_sum;
	}
	
	
	int getWeightedSum(TreeNode node,List<Integer> sumList){
		if(node==null){
			return 0;
	}

		if(node!=null && node.getLeft()==null && node.getRight()==null){
			sumList.add(node.getValue());
			return node.getValue();
	            }
	int curr_sum =  getWeightedSum(node.getLeft(),sumList)+getWeightedSum(node.getRight(),sumList)+node.getValue()	;
	sumList.add(curr_sum);
	return 	curr_sum;
			
	}


}
