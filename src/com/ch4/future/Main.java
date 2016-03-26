package com.ch4.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	void execute(){
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		
		Result result = new Result();
		Task t1 = new Task(result);
		Result r1 = null;
		Future<Result> future = executor.submit(t1, result);
		
		try {
			r1 = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(r1 != null){			
			System.out.println(r1.getTime());
		}else{
			System.out.println("NULL!!!");
		}
		executor.shutdown();
	}
	
	public static void main(String[] args){
		Main main = new Main();
		main.execute();
	}
}
