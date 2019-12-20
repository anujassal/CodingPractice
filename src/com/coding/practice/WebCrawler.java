package com.coding.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//O(n),O(n) space and time

public class WebCrawler {
	
	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		String startUrlHostName = getHostName(startUrl);
		HashSet<String> set = new HashSet<>();
		dfs(startUrlHostName,set,parser,startUrl);
		return new ArrayList<>(set);
		
	}
	
	public void dfs(String startUrlHostName,Set<String> set,HtmlParser parser,String url) {
		if(set.contains(url)) {
			return;
		}
		if(!getHostName(url).equals(startUrlHostName)) {
			return;
		}
		set.add(url);
		for(String urls:parser.getUrls(url)) {
			dfs(startUrlHostName,set,parser,url);
		}
	}
	
	public String getHostName(String url) {
		return url.split("/")[2];
	}

}
