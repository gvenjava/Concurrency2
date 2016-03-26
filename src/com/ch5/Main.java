package com.ch5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	private List<Product> generateProduct() {
		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= 9000000; i++) {
			Product p = new Product();
			p.setName("Product " + i);
			p.setPrice(10);
			list.add(p);
		}
		return list;
	}

	private void execute() {
		ForkJoinPool pool = new ForkJoinPool();
		List<Product> list = this.generateProduct();
		Action action = new Action(0, list.size(), 0.20, list);
		pool.execute(action);
		do {
			System.out.printf("Active   Count = %d%n",
					pool.getActiveThreadCount());
			System.out.printf("Steal    Count  = %d%n", pool.getStealCount());
			System.out.printf("Parralel Count  = %d%n", pool.getParallelism());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (!action.isDone());

		pool.shutdown();

		if (action.isCompletedNormally()) {
			System.out.println("Program completed normally!!!");
		}

		for (Product p : list) {
			if (p.getPrice() != 12) {
				System.out.println(p);
			}

		}

	}

	public static void main(String[] args){
		Main obj = new Main();
		obj.execute();
		
		/*double d = 0.2;
		double p = 10;
		System.out.println(p * (1+d));*/
	}
}
