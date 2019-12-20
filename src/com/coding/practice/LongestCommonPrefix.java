package com.coding.practice;


public class LongestCommonPrefix {
	
	    public static String longestCommonPrefix(String[] strs) {
	    	//int j = 0;
	    	StringBuilder output = new StringBuilder();
	    	String initialPrefix = "";
	    	if(strs.length==0)
	    		return"";
	    	if(strs.length==1)
	    		return strs[0];
	    	for(int i=0;i<1;i++){
	    		if(strs[i].length()==0 || strs[i].equals(""))
	    			return strs[i];
	    		for(int j=0;j<strs[i].length() && j<strs[i+1].length();j++){
	    			if(strs[i].charAt(j)==strs[i+1].charAt(j)){
	    				output.append(strs[i].charAt(j));
	    			}else{
	    				break;
	    			}
	    			initialPrefix = output.toString(); 
	    	}
	    	}
	    	if(strs.length>2){
	    	for(int i=2;i<strs.length;i++){
	    		if(strs[i].length()==0 || strs[i].equals(""))
	    			return strs[i];
    			initialPrefix = output.toString();
	    		output.setLength(0);
	    		for(int j=0;j<initialPrefix.length()&&j<strs[i].length();j++){
	    			if(strs[i].charAt(j)==initialPrefix.charAt(j)){
	    				output.append(strs[i].charAt(j));
	    			}else{
	    				break;
	    			}
	    			if(output.length()==0)
	    				return "";
	    		}
	    	}
	    	return output.toString();
	    	}else{
	    		return initialPrefix;
	    	}
	    }
	    
	    public static void main(String[] args){
	    	String[] str = {"flower","flow","flight"};
	    	String[] str2 = {"dog","racecar","car"};
	    	String[] str3 = {"d","d","c"};
	    	String[] str4 = {"","abc","abc"};
	    	String[] str5 = {};
	    	String[] str6 = {"abcd","ab","ab","ab"};
	    	String[] str7 = {"a"};
	    	String[] str8 = {"aa","aa"};
	    	String[] str9 = {"","",""};
	    	String[] str10 = {"abca","aba","aaab"};
	    	String[] str11 = {"abcda","abce","abc","a","abc","abcde"};
	    	String[] str12 = {"a","a","a","a","a","d"};
	    	String[] str13 = {"ab","ab","ab","ab","ab","ab"};
	    	String output = longestCommonPrefix(str);
	    	System.out.println(output);
	    	System.out.println(longestCommonPrefix(str2));
	    	System.out.println(longestCommonPrefix(str3));
	    	System.out.println(longestCommonPrefix(str4));
	    	System.out.println(longestCommonPrefix(str5));
	    	System.out.println(longestCommonPrefix(str6));
	    	System.out.println(longestCommonPrefix(str7));
	    	System.out.println(longestCommonPrefix(str8));
	    	System.out.println(longestCommonPrefix(str9));
	    	System.out.println(longestCommonPrefix(str10));
	    	System.out.println(longestCommonPrefix(str11));
	    	System.out.println(longestCommonPrefix(str12));
	    	System.out.println(longestCommonPrefix(str13));
	    }


}
