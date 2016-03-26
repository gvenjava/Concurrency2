package com.ch3.cyclicbarrier;

import java.util.Random;

public class MatrixMock {

	private int[][] data;
	
	public MatrixMock(int row,int column, int search) {
		int counter = 0;
		data = new int[row][column];
		Random random = new Random();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = random.nextInt(10);
				if(data[i][j] == search) {
					counter++;
				}
			}
		}
		
		System.out.printf("MatrixMock : This has generated %d for %d times.",search,counter);
	}
	
	public int[] getRow(int i) {
		if (i<data.length) {
			return data[i];
		}
		return null;
	}
}
