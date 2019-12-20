/**
 * Time complexity - O(n*x)
 * Space complexity - O(n*x)
 */


package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileSystem {
	
	public static List<List<String>> findDuplicates(String[] paths){
		Map<String,List<String>> map = new HashMap<>();
		for(String path:paths) {
			String[] p = path.split(" ");
			for(int i=1;i<p.length;i++) {
				StringBuilder root = new StringBuilder();
				int startIdx = p[i].indexOf('(');
				int endIdx = p[i].indexOf(')');
				String content = p[i].substring(startIdx+1,endIdx);
				root.append(p[0]).append(p[i].substring(0,startIdx));
				List<String> filePath = map.getOrDefault(content,new ArrayList<>());
				filePath.add(root.toString());
				map.put(content,filePath);
			}
		}
		
		return map.values().stream().filter(v->v!=null&&v.size()>1).collect(Collectors.toList());
	}
	//Pattern pattern = Pattern.compile(" (.*?)\\((.*?)\\)");
private static final String SPACE = " ";
    
    public static List<List<String>> findDuplicate(String[] paths) {
        Pattern pattern = Pattern.compile(" (.*?)\\((.*?)\\)");
		Matcher matcher = null;
		Map<String, List<String>> dirFileMap = new HashMap<String, List<String>>();
		String fileContent = null;
		for (String s: paths) {
			 matcher = pattern.matcher(s);
			 while (matcher.find()) {
				 fileContent = matcher.group(2);
				 List<String> dirList = dirFileMap.get(fileContent); 
				 if (dirList == null) {
					 dirList = new ArrayList<String>();
					 dirFileMap.put(fileContent, dirList);
				 }
				 dirList.add(s.split(SPACE)[0]+"/" +matcher.group(1));
			 }
		}
		return dirFileMap.values().stream().filter(v -> v != null && v.size() > 1)
				.collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
		String[] input = new String[5];
		input[0] = "root/a 1.txt(abcd) 2.txt(efgh)";
		input[1] = "root/c 3.txt(abcd)";
		input[2] = "root/c/d 4.txt(efgh)";
		input[3] = "root 4.txt(efgh)";
		input[4] = "root/a/1.txt,root/c/3.txt";
		List<List<String>> duplicates = findDuplicate(input);
		duplicates.forEach(d->System.out.println(d));
	}

}
