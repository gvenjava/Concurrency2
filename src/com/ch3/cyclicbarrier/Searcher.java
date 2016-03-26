package com.ch3.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {

	private int fromRow;
	private int toRow;
	private int search;
	private MatrixMock mock;
	private Results results;
	private CyclicBarrier barrier;

	public Searcher(int fromRow, int toRow, int search, MatrixMock mock, Results results, CyclicBarrier barrier) {
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.search = search;
		this.mock = mock;
		this.results = results;
		this.barrier = barrier;
		
	}

	@Override
	public void run() {
		
		int counter = 0;
		
		for (int i = fromRow; i < toRow; i++) {
			int[] row = mock.getRow(i);
			counter = 0;
			for (int j = 0; j < row.length; j++) {
				if(row[j] == search) {
					counter++;
				}
			}
			results.setCount(i, counter);
		}
		System.out.printf("%s: Lines processed from %d to %d.\n",Thread.currentThread().getName(),fromRow,toRow);
		
		try {
			barrier.await();
			
			System.out.println("CYCLIC BARRIER COUNT CALLED ...");
			
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Done.\n",Thread.currentThread().getName());
	}

}
