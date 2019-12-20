package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KPostOffice {
	
	private static class PostOffice implements Comparable<PostOffice>{
		
		int x;
		int y;
		
		public PostOffice(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (int) (prime * result + distanceFromSource);
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PostOffice other = (PostOffice) obj;
			if (distanceFromSource != other.distanceFromSource)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		double distanceFromSource;

		public double getDistanceFromSource() {
			return distanceFromSource;
		}

		public void setDistanceFromSource(double distanceFromSource) {
			this.distanceFromSource = distanceFromSource;
		}

		@Override
		public int compareTo(PostOffice o) {
			return (int) (distanceFromSource - o.distanceFromSource);
		}
	}
		
		public static List<PostOffice> getKNearestPOLocation(int k, List<PostOffice> poLocations,int[] startingLoc){
			List<PostOffice> poDistanceFromSrc = new ArrayList<>();
			for(int i=0;i<poLocations.size();i++){
				poLocations.get(i).setDistanceFromSource(getEulicidianDistfromSource(startingLoc, poLocations.get(i)));
				poDistanceFromSrc.add(poLocations.get(i));
			}
			return poDistanceFromSrc;
		}
		
		private static double getEulicidianDistfromSource(int[] src,PostOffice dest){
			int srcX = src[0];
			int srcY = src[1];
			int destX = dest.x;
			int destY = dest.y;
			int XSquare = (srcX-destX)*(srcX-destX);
			int YSqaure = (srcY-destY)*(srcY-destY);
			int diff = XSquare + YSqaure;
			
			return Math.sqrt(diff);
		}
		
	
	public static void main(String[] args){
		
		int[] src = {0,0};
		List<PostOffice> poLocations = new ArrayList<>();
		int k = 3;
		PostOffice po1 = new PostOffice(-16,5);
		PostOffice po2 = new PostOffice(-1,2);
		PostOffice po3 = new PostOffice(4,3);
		PostOffice po4 = new PostOffice(10,-2);
		PostOffice po5 = new PostOffice(0,3);
		PostOffice po6 = new PostOffice(-5,-9);
		poLocations.add(po1);
		poLocations.add(po2);
		poLocations.add(po3);
		poLocations.add(po4);
		poLocations.add(po5);
		poLocations.add(po6);
		
		List<PostOffice> poDistanceFromSrc = getKNearestPOLocation(k,poLocations,src);
		Collections.sort(poDistanceFromSrc);
		poDistanceFromSrc = poDistanceFromSrc.stream().limit(k).collect(Collectors.toList());
		poDistanceFromSrc.forEach(p->System.out.println("("+p.x +","+p.y+")"+"->"+p.distanceFromSource));
		
	}

}
