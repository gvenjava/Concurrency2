package com.ch5.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i =1;i<10000;i++)
			list.add(i);
		
		//pool.invoke(new Action(list, 10, "Thread",0,list.size()));
		Action task = new Action(list, 10, "Thread",0,list.size());
		pool.execute(task);
		System.out.println("Completed!!!");
		pool.shutdown();
		
		try {
			pool.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
