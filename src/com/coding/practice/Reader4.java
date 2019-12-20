package com.coding.practice;

public class Reader4 {
	
	String text = "abcdefghij";
	char[] textArr = text.toCharArray();
	int filePointer = 0;
	
	public int read4(char[] buff){
		int i=0;
		for(;i<4;i++){
			buff[i]=textArr[i+filePointer];
		}
		filePointer = filePointer+i;
		return buff.length;
	}

}
