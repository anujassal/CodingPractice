package com.coding.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileSystemUsingDFS {
	
	public static class Directory{
		List<Directory> subDirectories;
		List<File> files;
	}
	
	public static List<List<String>> findDuplicates(Directory dir){
		Map<String,List<String>> map = new HashMap<>();
		try {
			findDuplicatesInDir(map,dir);
		}catch(NoSuchAlgorithmException ex) {
			//log exception here
		}
		return map.values().stream().filter(v->v!=null && v.size()>1).collect(Collectors.toList());	
	}
	
	public static void findDuplicatesInDir(Map<String,List<String>> map,Directory dir) throws NoSuchAlgorithmException {
		for(File file:dir.files) {
			findDuplicateFilesUsingHashing(file,map);
		}
		for(Directory currDir:dir.subDirectories) {
			findDuplicatesInDir(map,currDir);
		}
	}
	
	public static void findDuplicateFilesUsingHashing(File file,Map<String,List<String>> map) throws NoSuchAlgorithmException {
		String fileContentHash = hash(file);
		if(map.containsKey(fileContentHash)) {
			map.get(fileContentHash).add(file.getAbsolutePath());
		}else {
			List<String> filePathList = new ArrayList<>();
			filePathList.add(file.getAbsolutePath());
			map.put(fileContentHash,filePathList);
		}
	}
	
	public static String hash(File file) throws NoSuchAlgorithmException {
		try {
			FileInputStream fileInput = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInput.read(data);
			fileInput.close();
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			String fileHash = new BigInteger(1,md.digest(data)).toString(16);
			return fileHash;
		}catch(IOException ex) {
			throw new RuntimeException("File cannot be read");
		}
	}

}
