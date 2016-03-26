package com.ch3.semaphores;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		PrintQueue printQueue=new PrintQueue();
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread"+i);
		}

		for (int i=0; i<10; i++){
			thread[i].start();
		}

	}

}
