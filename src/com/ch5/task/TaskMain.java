package com.ch5.task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TaskMain {

	private void execute() {
		final Result result = new Result();
		Run run = new Run(result);
		
		ForkJoinTask<Result> task = new RecursiveTask<Result>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected Result compute() {
				
				return result;
			}
			
			@Override
			public void complete(Result value) {
				super.complete(value);
				System.out.println("Complete:"+value);
			}
		}; //RecursiveTask.adapt(run, result);
		
		//task.complete(result);
		
//		new ForkJoinPool().invoke(task);
		new ForkJoinPool().execute(task);
		
		System.out.println("Execute started..");
		//task.complete(result);
		System.out.println(result);
		
	}

	public static void main(String[] args) {
		/*TaskMain obj = new TaskMain();
		obj.execute();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		int start = 12;
		int end = 20;
		int middle = start + (end-start)/2;
		System.out.println(middle);
		middle = (start + end)/2;
		System.out.println(middle);
	}
}
