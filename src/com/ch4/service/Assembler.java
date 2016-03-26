package com.ch4.service;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Assembler implements Runnable {

	private CompletionService<String> service;
	private boolean end;

	public Assembler(CompletionService<String> ser) {
		this.service = ser;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!end) {
			Future<String> future;

			String value = null;
			try {
				future = service.poll(20, TimeUnit.SECONDS);
				if (future != null)
					value = future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (value != null)
				end = false;

			System.out.printf("Assembler Result = %s%n", value);
			System.out.println("Assembler END");
		}

	}

}
