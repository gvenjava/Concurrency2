package com.ch4.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CalculatePrime {
	private final static int availableProcessor = Runtime.getRuntime().availableProcessors();
	
	
	public static void process(int number){
		ThreadPoolExecutor service =  (ThreadPoolExecutor) Executors.newFixedThreadPool(availableProcessor);
		
		List<DataDetails> list = new ArrayList<>();
		
		final int jobsPerProcessor = number / availableProcessor;
		
		int start = 0; 
		int end = 0;
		
		for(int i =0; i<availableProcessor; i++){
			start = (i == 0) ? 1 : (jobsPerProcessor * i) + 1;
			end = (i == 0) ? jobsPerProcessor : (start + jobsPerProcessor) -1;
			
			DataDetails details = new DataDetails(start,end);
			list.add(details);			
		}	
		
		if(end < number){
			DataDetails details = new DataDetails(end+1,number);
			list.add(details);			
		}
		
		
		List<Future<DataDetails>> future;
		
		try {
			future = service.invokeAll(list);
			service.shutdownNow();
			
			for(Future<DataDetails> f : future){
				/*try {
					DataDetails details = f.get();
					System.out.println(details);
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				service.awaitTermination(30, TimeUnit.SECONDS);
				System.out.println("COMPLTED!!!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("COMPLETED");
		}	
		
	}
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Runtime.getRuntime().availableProcessors());
		process(100);
	}

}
