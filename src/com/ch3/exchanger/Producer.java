package com.ch3.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable {

	private List<String> buffer;
	private Exchanger<List<String>> exchanger;

	public Producer(List<String> buf, Exchanger<List<String>> ex) {
		this.buffer = buf;
		this.exchanger = ex;
	}

	public void run() {
		int cycle = 1;
		for (int i=0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buffer.add(String.valueOf(i)+"--"+String.valueOf(j));
			}

			System.out.printf("CYCLE COUNT = %d ,PRODUCER BUFFER ITMES ::: %s%n",cycle, buffer);

			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.printf("PRODUCER BUFFER SIZE ::: %d%n", buffer.size());
			cycle++;
		}

	}

}
