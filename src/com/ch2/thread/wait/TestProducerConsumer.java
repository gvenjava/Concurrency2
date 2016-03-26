package com.ch2.thread.wait;

public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final EventStorage storage = new EventStorage(2);
		
		Thread t1 = new Thread(new Producer(storage,10));
		Thread t2 = new Thread(new Consumer(storage,10));
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
