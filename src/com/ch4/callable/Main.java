package com.ch4.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args){
		
		ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		
		
		
		for(int i =0; i<10; i++){			
			int fact = 1 + new Random().nextInt(5);
			fact = 5 * fact;
			System.out.println("FACT # = "+fact);
			Future<Integer> result = service.submit(new Factorial(fact));			
			list.add(result);
		}		
		
		do{
			System.out.printf("Completed Task %d%n", service.getCompletedTaskCount());
			
			for(int i = 0; i< list.size();i++){
				Future<Integer> task = list.get(i);
				System.out.printf("IsDone = %b%n",task.isDone());
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getLocalizedMessage());
			}
		}while(service.getCompletedTaskCount() < list.size());
		
		System.out.println("TASK COMPLETED = "+service.getCompletedTaskCount());
		
		for(int i =0;i<list.size();i++){
			Future<Integer> future = list.get(i);
			try {
				System.out.printf("Task of %d = %d%n",i,future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		service.shutdown();
	}
}
