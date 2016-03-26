package com.ch3.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

	private List<String> buffer;
	private Exchanger<List<String>> exchanger;

	public Consumer(List<String> buf, Exchanger<List<String>> ex) {
		this.buffer = buf;
		this.exchanger = ex;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		int cycle = 1;

		for (int j =0; j < 10; j++) {
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.printf("CYCLE COUNT = %d ,CONSUMER BUFFER SIZE ::: %d%n", cycle,buffer.size());

			for (int i = 0; i < 10; i++) {
				System.out.printf("ITEM IN CONSUMER ::: %s%n",
						buffer.get(0));
				buffer.remove(0);
			}

			System.out.printf("CONSUMER BUFFER SIZE ::: %d%n", buffer.size());
			cycle++;
		}
	}

}
