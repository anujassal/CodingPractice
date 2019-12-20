package com.coding.practice;

/*
 * Given nums = [1,1,2],
 * [0,0,1,1,1,2,2,3,3,4]
 * [1,2,3,3,3,4]

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 */
public class RemoveDuplicatesInPlace {
	public static int removeDuplicates(int[] nums) {
		
		int i = 0;
		for(int j=1;j<nums.length;j++){
			if(nums[i]!=nums[j]){
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
    }

	public static void main(String[] args){
		int[] nums = {1,2,3,3,3,4};
		int len = removeDuplicates(nums);
		System.out.println(len);
	
}

}

