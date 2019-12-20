package com.coding.practice;

public class Reader {
	
	//result buffer to store the end result
	//char[] resbuff;
	Reader4 r4 = new Reader4();
	char[] tempBuff; 
	int tempPointer = 0;
	
	public int read(char[] resBuff,int n){
		int i = 0;
		char[] cacheBuff = new char[256];
		int cachePointer = 0;
		if(n==0)
			return 0;
		
		if(tempBuff[0]!='\0'){
			//read from cacheBuff to resBuff
			while(tempPointer<tempBuff.length&&cachePointer<=n){
				cacheBuff[cachePointer] = tempBuff[tempPointer];
				cachePointer++;
				tempPointer++;
				n--;
			}
			if(tempPointer==tempBuff.length){
				tempPointer=0;//reset;
				tempBuff[0]='\0';
				tempBuff[1]='\0';
				tempBuff[2]='\0';
				tempBuff[3]='\0';
			}
		}
		
		while(i<n){
			r4.read4(resBuff);
			for(int j=0;j<resBuff.length;j++){
				if(resBuff[j]=='\0')
					break;
				tempBuff[j] = resBuff[j];
			}
			cacheBuff[cachePointer] = resBuff[i];
			tempPointer++;
			cachePointer++;
			i++;	
		}
		int k=0;
		for(;k<cacheBuff.length;k++){
			if(cacheBuff[k]=='\0')
				break;
			System.out.println(cacheBuff[k]);
		}
		return k;	
	}
	
	public static void main(String[] args){
		Reader r = new Reader();
		r.tempBuff = new char[4];
		r.tempBuff[0]='\0';
		r.tempBuff[1]='\0';
		r.tempBuff[2]='\0';
		r.tempBuff[3]='\0';
		char[] resBuff = new char[4];
		System.out.println(r.read(resBuff, 1));
		System.out.println(r.read(resBuff, 2));
		System.out.println(r.read(resBuff, 2));
	}

}
