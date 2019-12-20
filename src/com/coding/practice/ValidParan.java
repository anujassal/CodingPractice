package com.coding.practice;


public class ValidParan {
	
	public static void validParan(char[] str,int l,int r,int count) {
		if(l<0||r<l) {
			return;
		}
		if(l==0&&r==0) {
			System.out.println(str);
		}
		if(l>0) {
			str[count] = '(';
			validParan(str,l-1,r,count+1);
		}
		if(r>l) {
			str[count] = ')';
			validParan(str,l,r-1,count+1);
		}
	}
	
	public static void main(String[] args) {
		int count = 3;
		char[] str = new char[count*2];
		validParan(str,count,count,0);
	}

}
