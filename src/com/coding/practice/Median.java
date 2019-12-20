package com.coding.practice;
/**
 * 
 * @author charan
 * nums1 = [1,3,4]
 * num2 = [2,5,6]
 * 
 * Median = 2.0
 *
 */

public class Median {
	
	public static void main(String[] args){
		int[] nums1 = {1,3,4};
		int[] nums2 = {2,5,6};
		System.out.println(getMedian(nums1,nums2));
		
	}
	
	private static int getMedian(int[] nums1,int[] nums2){
		int totalLen = nums1.length + nums2.length;
		int[] c = new int[totalLen];
		int i=0,j=0,k=0;
		while(i<nums1.length&&j<nums2.length){
			if(nums1[i]>nums2[j]){
				c[k++] = nums2[j++];
			}else{
				c[k++] = nums1[i++];
			}
		}
		while(i<nums1.length){
			c[k++]=nums1[i++];
		}
		while(j<nums2.length){
			c[k++]=nums2[j++];
		}
		int m = c.length/2;
		int median = 0;
		if(m%2!=0){
			median = c[m]/2;
		}else
			median = (c[m]+c[m-1])/2;
		return c[median];
	}


}
