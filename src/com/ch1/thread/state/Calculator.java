package com.ch1.thread.state;

public class Calculator implements Runnable {

	private int i ;
	
	public Calculator(int i ) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int j = 1;j <=10; j++){
			System.out.printf("%d * %d = %d%n",i,j,i*j);
		}
	}
}
