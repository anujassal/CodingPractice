package com.coding.practice;

public class StringCompression2 {
	
	public static void main(String[] args){
		String[] strArr = new String[] {"a","a","b","b","c","c","c"};
		
		System.out.println(StringCompression(strArr));
		for(int i=0;i<strArr.length;i++){
			System.out.println(strArr[i]);
		}
	}
	
	private static int StringCompression(String[] strArr){
		int i=0;
		int j=0;
		int charCnt = 0;
		int k=0;
		if(strArr.length==0){
			return 0;
		}
		if(strArr.length==1){
			return 1;
		}
		while(i<strArr.length&&j<strArr.length){
			if(strArr[i]==strArr[j]){
				j++;
				charCnt++;
			}else{
				strArr[k] = strArr[i];
				strArr[k+1] = String.valueOf(charCnt);
				charCnt=0;
				k=k+2;
				while(i!=j){
					i++;
				}
			}
		}
		strArr[k] = strArr[i];
		strArr[k+1] = String.valueOf(charCnt);
		k=k+2;
		charCnt = k;
		while(k<strArr.length){
			strArr[k] = "";
			k++;
		}
		return charCnt;
	}

}
