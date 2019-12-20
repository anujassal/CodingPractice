package com.coding.practice;

public class KMPWordPattern {
	
	public static void main(String[] args) {
		String pattern="ABABCABAB";
		String text = "ABABDABACDABABCABAB";
		int[] lps = computeLPSArray(pattern);
		int index = kmpWordSearch(pattern,text,lps);
		System.out.println(index);
		
	}
	
	public static int[] computeLPSArray(String pattern) {
		int i=1;
		int j=0;
		int m = pattern.length();
		int[] lps = new int[m];
		while(i<m) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				j++;
				lps[i]=j;
				i++;
			}else {
				if(j!=0) {
					j=lps[j-1];
				}else {
					lps[i]=j;
					i++;
				}
			}
		}
		return lps;
	}
	
	public static int kmpWordSearch(String pattern,String text,int[] lps) {
		int i=0;
		int j=0;
		int m=pattern.length();
		int n=text.length();
		while(i<n) {
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;
				j++;
			}
			if(j==m) {
				j=lps[j-1];
				return j;
			}
			else if(i<n&&pattern.charAt(j)!=text.charAt(i)) {
					if(j!=0) {
						j=lps[j-1];
					}else {
						i++;
					}
				}
			}
		return j;
	}

}
