package com.coding.practice;


public class Apple extends Fruit{
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private String color;
	private int weight;
	
	public Apple(String color, int weight){
		this.color = color;
		this.weight = weight;
	}
	
	public Apple(int weight){
		this.weight = weight;
	}

}
