package com.coding.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity {
	/*
	 * if words1.len != words2.len return false
	 * if words1 = words2 and pair is empty return true
	 * pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]
	 */
	 public static boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
	        if(words1.length==0 || words2.length==0)
	        	return false;
	        if(words1.length!=words2.length)
	        	return false;
	        if(pairs.isEmpty()){
	        	for(int i=0;i<words1.length;i++){
	        		if(words1[i].equals(words2[i]))
	        			return false;
	        	}
	        	return true;
	        }
	        Map<String,String> map = new HashMap<>();
	        for(int i=0;i<pairs.size();i++){
	        	map.put(pairs.get(i).get(0), pairs.get(i).get(1));
	        	map.put(pairs.get(i).get(1), pairs.get(i).get(0));
	        }
	        
	        for(int i=0;i<words1.length;i++){
	        	//get the word from words1 and get the match out of pair. if match found check if the word is there in the same location in words2.
	        	if(map.containsKey(words1[i])){
	        		if(!words2[i].equals(map.get(words1[i])))
	        			return false;
	        	}else
	        		return false; 
	        }
        	return true;
	    }
	 
	 public static void main(String[] args){
		 List<List<String>> pairs= new ArrayList<>();
		 List<String> p1 = Arrays.asList("great","fine");
		 List<String> p2 = Arrays.asList("acting","drama");
		 List<String> p3 = Arrays.asList("skills","talent");
		 pairs.add(p1);
		 pairs.add(p2);
		 pairs.add(p3);
		 //"great acting skills" and "fine drama talent" 
		 String words1 = "great acting skills";
		 String words2 = "fine drama talent";
		 String[] words1Arr = words1.split(" ");
		 String[] words2Arr = words2.split(" ");
		 System.out.println(areSentencesSimilar(words1Arr, words2Arr,pairs));

	 }

}
