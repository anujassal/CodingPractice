package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileSystemRegex {
	
	public static List<List<String>> findDuplicates(String[] paths){
		Pattern pattern = Pattern.compile(" (.*?)\\((.*?)\\)");
		Matcher matcher = null;
		String fileContent = null;
		Map<String,List<String>> map = new HashMap<>();
		for(String s:paths) {
			matcher = pattern.matcher(s);
			while(matcher.find()) {
				fileContent = matcher.group(2);
				List<String> fileList = map.get(fileContent);
				if(fileList==null) {
					fileList = new ArrayList<>();
					map.put(fileContent,fileList);
				}
				fileList.add(s.split(" ")[0]+"/"+matcher.group(1));
			}
		}
		return map.values().stream().filter(v->v!=null && v.size()>1).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		String[] input = new String[5];
		input[0] = "root/a 1.txt(abcd) 2.txt(efgh)";
		input[1] = "root/c 3.txt(abcd)";
		input[2] = "root/c/d 4.txt(efgh)";
		input[3] = "root 4.txt(efgh)";
		input[4] = "root/a/1.txt,root/c/3.txt";
		List<List<String>> duplicates = findDuplicates(input);
		duplicates.forEach(d->System.out.println(d));
	}

}
