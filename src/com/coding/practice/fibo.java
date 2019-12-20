package com.coding.practice;


public class fibo {
	
	 static int fiboRec(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else if(n>1) {
			return fiboRec(n-1)+fiboRec(n-2);
		}else {
			return -1;
		}
	}
	
	 static int fibIterative(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1 || n==2) {
			return 1;
		}
		int a=1;
		int b=1;
		int c=0;
		for(int i=3;i<=n;i++) {
			c = a+b;
			a=b;
			b=c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(fiboRec(1));
		System.out.println(fibIterative(1));
		System.out.println(fiboRec(2));
		System.out.println(fibIterative(2));
		System.out.println(fiboRec(3));
		System.out.println(fibIterative(3));
		System.out.println(fiboRec(5));
		System.out.println(fibIterative(5));
	}

}
