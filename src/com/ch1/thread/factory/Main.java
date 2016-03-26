package com.ch1.thread.factory;

public class Main {

	public static void main(String[] args) {
		MyThreadFactory threadFactory = new MyThreadFactory("CustomThreadFactory");
		Task task = new Task();
		
		for (int i = 0; i < 10; i++) {
			Thread thread = threadFactory.newThread(task);
			thread.start();
		}
		
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n",threadFactory.getStats());
	}

}
