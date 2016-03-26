package com.ch3.cyclicbarrier;

public class Results {

	private int[] counts;
	
	public Results(int rows) {
		counts = new int[rows];
	}
	
	public void setCount(int row, int count) {
		counts[row] = count;
	}
	
	public int[] getCount() {
		return counts;
	}
}
