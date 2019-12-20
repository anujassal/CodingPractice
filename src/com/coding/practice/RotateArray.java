package com.coding.practice;


public class RotateArray {
	
	public static void main(String args[]){
		rotateArray();
		}
	
	public static void rotateArray(){
		int y = 5;
		int[] a = new int[]{1,2,3,4,5,6,7};
		int[] b = new int[y];
		int z = a.length - y;
		int[] c = new int [a.length];
		for(int i=0;i<y;i++)
			b[i] = a[i];
		for(int i=0;i<z;i++)
			c[i]=a[i+y];
		for(int i=z,j=0;i<a.length;i++,j++)
			c[i]=b[j];
		for(int i=0;i<a.length;i++)
			System.out.println(c[i]);
		
	}

}
