package com.coding.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * id:12 state:fl name:weston city:tampa
 * id:12 state:fl name:weston city:tampa
 * id:13 state:fl name:weston city:orlando
 * id:14 state:nc name:weston city:charlotte
 * id:15 state:sc name:weston city:columbia
 * 
 *
 */
public class EmployeeSort{
	
	public class Employee implements Comparable<Employee>{
		int empId;
		String name;
		String city;
		String state;
		
		@Override
		public boolean equals(Object obj) {
			if(obj==null)
					return false;
			return obj instanceof Employee && empId == ((Employee)obj).empId;
		}
		
		@Override
		public int hashCode() {
			return 0;
		}
		
		@Override
		public int compareTo(Employee e) {
			int c = e.city.compareTo(this.city);
			if(c==0) {
				c = e.name.compareTo(this.name);
			}
			return c;
		}
		
		@Override
		public String toString() {
			return "empId:"+empId+"name:"+name+"city:"+city;
		}
	}
	
	//TODO
	/*public static void main(String[] args) {
		Map<String,SortedSet<Employee>> map = new TreeMap<>();
		for(Employee e:list) {
			if(map.containsKey(e.state)) {
				map.get(e.state).add(e);
			}else {
				SortedSet<Employee> set = new TreeSet<>();
				set.add(e);
				map.put(e.state,set);
			}
		}
		
		for(Map.Entry<String,SortedSet<Employee>> entry:map.entrySet()) {
			String key = entry.getKey();
			SortedSet<Employee> value = entry.getValue();
			System.out.println(key);
			value.forEach(emp->System.out.println(emp));
		}	
	}*/

}
