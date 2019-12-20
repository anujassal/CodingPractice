package com.coding.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
 */
public class ValidParanthesis {
	
	private static final Map<Character,Character> paranthesisMap = new HashMap<>();
	static{
		paranthesisMap.put(')', '(');
		paranthesisMap.put('}', '{');
		paranthesisMap.put(']', '[');
	}
	private static final Collection<Character> STARTING_BRACES = paranthesisMap.values();
	private static final Stack<Character> stk = new Stack<>();
	
	public static boolean isValid(String s){
		char c;
		boolean isValid = false;
		if(s==null || s.length()==0)
			return true;
		if(s.length()==1)
			return false;
		for(int i=0;i<s.length();i++){
			c = s.charAt(i);
			if(STARTING_BRACES.contains(c)){
				stk.push(c);
			}else{
				if(!stk.isEmpty())
					if(paranthesisMap.get(c).equals(stk.pop())){
						isValid = true;
						continue;
					}
					else{
						isValid = false;
						return isValid;
					}
			}
		}
		if(!stk.isEmpty()){
			isValid = false;
			stk.clear();
		}
		return isValid;	
	}
	
	public static void main(String[] args){
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid(""));
		System.out.println(isValid("(}){[]"));
		System.out.println(isValid("(("));
		System.out.println(isValid("){"));
		System.out.println(isValid("([]"));
		System.out.println(isValid("{[]}"));
		
	}

}
