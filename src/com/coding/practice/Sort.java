package com.coding.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Sort {
	
	public static void sortArrayInDescOrder() {
		Integer[] arr = {13, 7, 6, 45, 21, 9, 2, 100}; 
		Arrays.sort(arr,Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	class Student{
		int rollNo;
		String name;
		public Student(int no,String n) {
			rollNo = no;
			name = n;
		}
		
		public String toString() {
			return rollNo+" "+name;
		}
	}
	
	class SortByRollNo implements Comparator<Student>{
		public int compare(Student a,Student b) {
			return a.rollNo - b.rollNo;
		}
	}
	
	class SortByRollNoDesc implements Comparator<Student>{
		public int compare(Student a,Student b) {
			return b.rollNo - a.rollNo;
		}
	}
	
	class Box{
		int num;
		public Box(int n) {
			num = n;
		}
	}
	
	class BoxComparator implements Comparator<Box>{

		@Override
		public int compare(Box o1, Box o2) {
			return o1.num-o2.num;
		}
		
	}
	
	public static void main(String[] args) {
		sortArrayInDescOrder();
		Sort sort = new Sort();
		Student[] arr = {
						sort.new Student(111, "bbbb"),
						sort.new Student(131, "aaaa")
						};
		Arrays.sort(arr,sort.new SortByRollNo());
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.print("\n");
		Arrays.sort(arr,sort.new SortByRollNoDesc());
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");	
		}
		
		MyCustomList<Box> l = new MyCustomList<>(sort.new BoxComparator());
		l.add(sort.new Box(2));
		l.add(sort.new Box(1));
		l.add(sort.new Box(8));
		l.add(sort.new Box(0));
		
		Iterator<Box> i = l.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().num);
		}
	}

}
