package com.coding.practice;

import java.util.Random;

public class ReplaceCharacters {
	
	public static void main(String[] args){
		System.out.println(replace("??????"));
	}
	
	 public static String replace(String riddle){
	        char[] strArray = riddle.toCharArray();
	        String replacedString;
	        for(int i=0;i<strArray.length;i++){
	        	if(i==strArray.length-1){
	        		strArray[i] = generateRandomChar(strArray[i],'\0');
	        	}
	        	if (strArray[i]=='?' && i!=strArray.length-1){
	                strArray[i] = generateRandomChar(strArray[i],strArray[i+1]);
	            }
	        	replacedString = String.valueOf(strArray);
	        }
	        replacedString = String.valueOf(strArray);
	        return replacedString;
	    }
	    
	    private static char generateRandomChar(char front, char back){
	        Random rnd = new Random();
	        char c = (char)(rnd.nextInt(26)+'a');
	        while(c==front || c==back)
	        	c = (char)(rnd.nextInt(26)+'a');
	        return c;
	    }
    
	
	

}
