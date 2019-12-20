package com.coding.practice;

public class StrStr {
	/**
	 * Input: haystack = "hello", needle = "ll"  hello, eo
Output: 2
Input: haystack = "aaaaa", needle = "bba"
Output: -1
	 * @param haystack
	 * @param needle
	 * @return
	 * O(n2)
	 */
	
	 public static int strStr(String haystack, String needle) {
		 if(haystack==null||needle==null) {
			 return -1;
		 }
		 if(needle.length()==0) {
			 return 0;
		 }
		 int m = haystack.length();
		 int n = needle.length();
		 if(m<n) {
			 return -1;
		 }

		 for(int i=0;i<=m-n;i++) { 
			 int j;
				 for(j=0;j<n;j++) {
					 if(haystack.charAt(i+j)!=needle.charAt(j)) {
						 break;
					 }
				 }
				 if(j==n) {
					 return i;
				 }
		 }
		 return -1;   
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(strStr("hello","ll")); 
		 System.out.println(strStr("aaaaa","bba")); 
		 System.out.println(strStr("hello","eo")); 
		 System.out.println(strStr("mississippi","mississippi")); 
		 System.out.println(strStr("mississippi","issip"));
	 }
}
