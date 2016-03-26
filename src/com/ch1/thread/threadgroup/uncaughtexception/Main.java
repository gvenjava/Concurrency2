package com.ch1.thread.threadgroup.uncaughtexception;

public class Main {

	public static void main(String[] args) {
//		MyThreadGroup group = new MyThreadGroup("CustomThreadGroup");
		ThreadGroup group1 = new ThreadGroup("MY-CUSTOM-GROUP"){
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.printf("The thread %s has thrown an Exception\n",t.
						getId());
				e.printStackTrace(System.out);
				System.out.printf("Terminating the rest of the Threads\n");
				interrupt();
			}
		};
		Task task = new Task();
		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(group1, task);
			thread.start();
		}
	}

}
